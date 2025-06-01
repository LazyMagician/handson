package com.exercise.file.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PrimitiveDataHelper {

	DataInputStream inputStream;

	DataOutputStream outputStream;

	public void readDataFromDatFile( String inputFile ) {
		try {
			inputStream = new DataInputStream( new FileInputStream( inputFile ) );
			int data;
			while ( ( data = inputStream.readInt() ) != -1 ) {
				System.out.println( data + "\n" );
			}
		}
		catch ( Exception e ) {
			System.out.println( "Error occurred while reading data from file" );
			e.printStackTrace();
		}
		finally {
			try {
				inputStream.close();
			}
			catch ( IOException e ) {
				e.printStackTrace();
			}
		}
	}

	public void writeDataToFile( String outputFile ) {
		try {
			outputStream = new DataOutputStream( new FileOutputStream( outputFile ) );
			for ( int i = 0; i < 10; i++ )
				outputStream.writeInt( i );
			outputStream.writeInt( -1 );
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
		finally {
			try {
				outputStream.close();
			}
			catch ( IOException e ) {
				e.printStackTrace();
			}
		}

	}
}
