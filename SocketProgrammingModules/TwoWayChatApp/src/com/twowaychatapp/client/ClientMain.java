package com.twowaychatapp.client;

public class ClientMain {

	public static void main( String[] args ) {
		ChatClient client = new ChatClient( "127.0.0.1", 6400 );
		client.startClient();
	}
}
