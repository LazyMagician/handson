package com.exercise.file.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.exercise.file.interfaces.Copier;

public class FileCopier implements Copier {

	private BufferedReader fileReader;

	private BufferedWriter fileWriter;

	public FileCopier( String inputFile, String outputFile ) {
		formReaderAndWriter( inputFile, outputFile );
	}

	public void copyFileData() {
		String line;
		try {
			while ( ( line = fileReader.readLine() ) != null ) {
				System.out.println( line );
				fileWriter.write( line );
				//				fileWriter.newLine();
			}
			System.out.println( "File copied successfully!" );
		}
		catch ( IOException e ) {
			e.printStackTrace();
		}
		finally {
			try {
				fileReader.close();
				fileWriter.close();
			}
			catch ( Exception e ) {
				System.out.println( "Error occurred while closing the streams!" );
				e.printStackTrace();
			}

		}
	}

	private void formReaderAndWriter( String inputFile, String outputFile ) {
		try {
			fileReader = new BufferedReader( new FileReader( inputFile ) );
			fileWriter = new BufferedWriter( new FileWriter( outputFile ) );

		}
		catch ( Exception e ) {
			System.out.println( "Something went wrong while forming reader and writer" );
			e.printStackTrace();
		}
	}

}
