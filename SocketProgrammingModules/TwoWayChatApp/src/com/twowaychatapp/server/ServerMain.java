package com.twowaychatapp.server;

public class ServerMain {

	public static void main( String[] args ) {
		ChatServer server = new ChatServer( 6400 );
		server.startServer();
	}

}
