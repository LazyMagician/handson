package com.simplechatapp.client;

public class ClientMain {

	public static void main( String[] args ) {
		ChatClient client = new ChatClient( "127.0.0.1", 6500 );
		client.startClient();
	}
}
