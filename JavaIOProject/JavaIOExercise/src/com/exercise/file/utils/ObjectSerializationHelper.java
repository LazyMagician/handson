package com.exercise.file.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.exercise.dummyclass.Student;

public class ObjectSerializationHelper {

	ObjectOutputStream objInputStream;

	ObjectInputStream objOutputStream;

	public <T> void serialize( String outputFile, Object obj, Class<T> classType ) {
		try {
			T castedObj = null;
			if ( classType.isInstance( obj ) ) {
				castedObj = classType.cast( obj );
			}
			objInputStream = new ObjectOutputStream( new FileOutputStream( outputFile ) );
			objInputStream.writeObject( castedObj );
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
		finally {
			try {
				objInputStream.close();
			}
			catch ( IOException e ) {
				e.printStackTrace();
			}
		}
	}

	public <T> void deserialize( String inputFile, Class<T> classType ) {
		try {
			objOutputStream = new ObjectInputStream( new FileInputStream( inputFile ) );
			T castedObj = ( T ) objOutputStream.readObject();
			if ( castedObj instanceof Student ) {
				Student stud = ( Student ) castedObj;
				System.out.println( stud.getId() + " " + stud.getName() + " " + stud.getBranch() );
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
	}
}
