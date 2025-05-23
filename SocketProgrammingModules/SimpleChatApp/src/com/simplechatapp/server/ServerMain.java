package com.simplechatapp.server;

public class ServerMain {

	public static void main( String[] args ) {
		ChatServer server = new ChatServer( 6500 );
		server.startServer();
	}
}
