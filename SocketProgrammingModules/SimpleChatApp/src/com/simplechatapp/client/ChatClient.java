package com.simplechatapp.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ChatClient {

	private Socket sc;

	private String ip;

	private int port;

	private DataOutputStream out;

	private DataInputStream in;

	public ChatClient( String ip, int port ) {
		this.ip = ip;
		this.port = port;
	}

	public void startClient() {
		try {
			sc = new Socket( ip, port );
			System.out.println( "Connected to server successfully" );
			DataOutputStream out = new DataOutputStream( sc.getOutputStream() );
			DataInputStream in = new DataInputStream( System.in );
			String msg = "";
			while ( !msg.equals( "quit" ) ) {
				msg = in.readLine();
				out.writeUTF( msg );
			}

		}
		catch ( Exception e ) {
			System.out.println( "Error occurred during connection" );
			e.printStackTrace();
		}
		try {
			if ( out != null )
				out.close();
			if ( in != null )
				in.close();
			if ( sc != null )
				sc.close();
		}
		catch ( Exception e2 ) {
			System.out.println( "Something went wrong while closing the connections" );
			e2.printStackTrace();
		}
	}
}
