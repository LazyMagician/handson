package com.twowaychatapp.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClient {

	private Socket socket;

	private DataOutputStream out;

	private BufferedReader in;

	private DataInputStream inputFromServer;

	private String ip;

	private int port;

	public ChatClient( String ip, int port ) {
		this.ip = ip;
		this.port = port;
	}

	public void startClient() {
		try {
			socket = new Socket( ip, port );
			System.out.println( "Client connected to server successfully at ip : " + ip + " , port : " + port );
			in = new BufferedReader( new InputStreamReader( System.in ) );
			out = new DataOutputStream( socket.getOutputStream() );
			inputFromServer = new DataInputStream( socket.getInputStream() );
			//			client name 
			System.out.println( "Enter your name : " );
			String name = in.readLine();
			// server name
			out.writeUTF( name );
			String serverName = inputFromServer.readUTF();
			System.out.println( "SERVER NAME : " + serverName );

			writeMsgToServer( serverName );
			readMsgFromServer( serverName );

		}
		catch ( Exception e ) {
			System.out.println( "Error occurred while starting client" );
		}
	}

	private void readMsgFromServer( String serverName ) {
		new Thread( () -> {
			String response;
			try {

				while ( ( response = inputFromServer.readUTF() ) != null ) {
					//				while ( true ) {
					//					response = inputFromServer.readLine();
					System.out.println( "[" + serverName + "]: " + response );
				}

			}
			catch ( Exception e ) {
				System.out.println( "Error occurred while reading msg from server " + serverName );
			}
		} ).start();

	}

	//			Thread writing msg to server 
	private void writeMsgToServer( String serverName ) {
		System.out.println( "Write msg to server" );

		new Thread( () -> {
			try {
				String msg;
				while ( ( msg = in.readLine() ) != null ) {
					//				while ( true ) {
					//					msg = in.readLine();
					out.writeUTF( msg );
				}
			}
			catch ( Exception e ) {
				System.out.println( "Error occurred while sending msg to " + serverName );
			}
		} ).start();
	}

}
