package com.twowaychatapp.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	private ServerSocket ss;

	private Socket socket;

	private BufferedReader in;

	private DataInputStream inputFromClient;

	private DataOutputStream out;

	private int port;

	public ChatServer( int port ) {
		this.port = port;
	}

	public void startServer() {
		try {
			ss = new ServerSocket( port );
			System.out.println( "Waiting for the client to connect to server " );
			socket = ss.accept();
			System.out.println( "Client connected successfully" );
			in = new BufferedReader( new InputStreamReader( System.in ) );
			inputFromClient = new DataInputStream( socket.getInputStream() );

			out = new DataOutputStream( socket.getOutputStream() );
			String clientName = inputFromClient.readUTF();

			System.out.println( "Enter server name" );
			String serverName = in.readLine();
			out.writeUTF( serverName );

			System.out.println( "CLIENT NAME : " + clientName );
			readFromClient( clientName );
			writeToClient( clientName );

		}
		catch ( Exception e ) {
			System.out.println( "Error occurred while starting server" );
			e.printStackTrace();
		}

	}

	//	Write msg to client 
	private void writeToClient( String clientName ) {
		System.out.println( "Write msg to client" );
		new Thread( () -> {
			String msg = "";
			try {
				while ( ( msg = in.readLine() ) != null ) {
					//				while ( true ) {
					//					msg = in.readLine();
					out.writeUTF( msg );
				}
			}
			catch ( Exception e ) {
				System.out.println( "Error occurred while writing msg to client " + clientName );
			}

		} ).start();
	}

	//	Read msg from client
	private void readFromClient( String clientName ) {

		new Thread( () -> {
			String msg = "";
			try {
				while ( ( msg = inputFromClient.readUTF() ) != null ) {
					//				while ( true ) {
					//					msg = inputFromClient.readLine();
					System.out.println( "[" + clientName + "]: " + msg );
				}
			}
			catch ( Exception e ) {
				System.out.println( "Error occurred while reading msg from client " + clientName );
			}

		} ).start();
		;
	}
}
