package com.simplechatapp.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	private ServerSocket ss;

	private Socket sc;

	private DataInputStream in;

	//	private DataOutputStream out;

	private int port;

	public ChatServer( int port ) {
		this.port = port;
	}

	public void startServer() {
		try {
			ss = new ServerSocket( port );
			System.out.println( "Waiting for the client to connect to port : " + port );
			sc = ss.accept();
			System.out.println( "Client connected successfully" );
			in = new DataInputStream( sc.getInputStream() );
			//			out = new DataOutputStream( sc.getOutputStream() );
			String msg = "";
			while ( !msg.equals( "quit" ) ) {
				msg = in.readUTF();
				System.out.println( "[MSG] - " + msg );
			}
		}
		catch ( Exception e ) {
			System.out.println( "ERROR during communication with server" );
			e.printStackTrace();
		}
		try {
			if ( in != null )
				in.close();
			if ( sc != null )
				sc.close();

			//			out.close();
		}
		catch ( Exception e ) {
			System.out.println( "Something went wrong while closing the connections" );
			e.printStackTrace();
		}
	}

}
