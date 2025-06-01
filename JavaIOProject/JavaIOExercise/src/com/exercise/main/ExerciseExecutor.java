package com.exercise.main;

import java.util.Scanner;

import com.exercise.dummyclass.Student;
import com.exercise.file.interfaces.Copier;
import com.exercise.file.utils.BinaryFileCopier;
import com.exercise.file.utils.FileCopier;
import com.exercise.file.utils.ObjectSerializationHelper;
import com.exercise.file.utils.PrimitiveDataHelper;

public class ExerciseExecutor {

	public static void main( String[] args ) {
		System.out.println( "Which exercise would you like to test: \n 1. Copy Text File" + "\n 2. Copy Binary file \n 3. Write and read primitive data" + "\n 4. Object Serialization \n 5. In-memory byte sream " );
		Scanner sc = new Scanner( System.in );
		int option = sc.nextInt();
		Copier copier;
		String inputFile = "";
		String outputFile = "";
		int opt;
		switch( option ) {
		case 1:
			System.out.println( "Warn: This program will copy only the text in the file new lines and any such special char will be ignored " );
			readFromUser( sc, inputFile, outputFile );
			copier = new FileCopier( inputFile, outputFile );
			copier.copyFileData();
			break;
		case 2:
			System.out.println( "Copy Binary File" );
			readFromUser( sc, inputFile, outputFile );
			copier = new BinaryFileCopier( inputFile, outputFile );
			copier.copyFileData();
			break;
		case 3:
			System.out.println( "Read And Write pritive data" );
			PrimitiveDataHelper helper = new PrimitiveDataHelper();
			System.out.println( " 1. read from dat file \n 2. write to dat file" );

			opt = sc.nextInt();
			if ( opt == 1 ) {
				System.out.println( "Enter the input file" );
				inputFile = sc.next();
				helper.readDataFromDatFile( inputFile );
			}
			else {
				System.out.println( "Enter the output file" );
				outputFile = sc.next();
				helper.writeDataToFile( outputFile );

			}
		case 4:
			System.out.println( "Object serialization" );
			System.out.println( " 1. Serialize an object and store to file \n 2. Read from file and deserialize an object" );
			opt = sc.nextInt();
			ObjectSerializationHelper objHelper = new ObjectSerializationHelper();
			if ( opt == 1 ) {
				System.out.println( "Enter output file :" );
				outputFile = sc.next();
				Student stud = new Student( 1, "Ananthu", "CSE" );
				objHelper.serialize( outputFile, stud, Student.class );
			}
			else {
				System.out.println( "Enter input file :" );
				inputFile = sc.next();
				objHelper.deserialize( inputFile, Student.class );
			}
		default:
			break;
		}
	}

	private static void readFromUser( Scanner sc, String inputFile, String outputFile ) {
		System.out.println( "Enter input file : " );
		inputFile = sc.next();
		System.out.println( "Enter output file : " );
		outputFile = sc.next();
	}

}
