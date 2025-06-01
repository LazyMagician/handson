package com.exercise.file.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.exercise.file.interfaces.Copier;

public class BinaryFileCopier implements Copier {

	private BufferedInputStream bis;

	private BufferedOutputStream bos;

	public BinaryFileCopier( String inputFile, String outputFile ) {
		formWriterAndReader( inputFile, outputFile );
	}

	private void formWriterAndReader( String inputFile, String outputFile ) {
		try {
			bis = new BufferedInputStream( new FileInputStream( inputFile ) );
			bos = new BufferedOutputStream( new FileOutputStream( outputFile ) );
			//		File file = new File("name");
			//		FileInputStream stream = new FileInputStream( file );
		}
		catch ( FileNotFoundException e ) {
			System.out.println( "Error while creating i/o streams" );
			e.printStackTrace();
		}
	}

	@Override
	public void copyFileData() {
		byte[] byteBuff = new byte[1024]; // 1kb buffer
//		Need to use bytesRead because at the end there is chance that less than 1k is read
//		so garbage value will be written
		int bytesRead ;
		
		try {
			while ( (bytesRead = bis.read( byteBuff )) != -1 ) {
				bos.write( byteBuff,0,bytesRead );
			}
			System.out.println( "Binary file copied successfully" );
		}
		catch ( IOException e ) {
			System.out.println( "Error occurred while reading binary file" );
			e.printStackTrace();
		}
	}
}
