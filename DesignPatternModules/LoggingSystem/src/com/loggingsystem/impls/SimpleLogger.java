package com.loggingsystem.impls;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.loggingsystem.interfaces.Logger;

public class SimpleLogger implements Logger {

	private static SimpleLogger logger;

	private File file = new File( "/home/ananthuachary/log.txt" );

	//	method 1
	public static SimpleLogger getInstance() {
		if ( logger == null ) {
			logger = new SimpleLogger();
		}
		return logger;
	}
	//	

	//	method 2
	//	public static synchronized SimpleLogger getInstance() {
	//		if ( logger == null ) {
	//			logger = new SimpleLogger();
	//		}
	//		return logger;
	//	}

	//	method 3 
	//	private static logger = new SimpleLogger();
	//	public static synchronized SimpleLogger getInstance() {
	//
	//		return logger;
	//	}

	//	method 4
	//	private static volatile logger = new SimpleLogger();
	//	public static SimpleLogger getInstance() {
	//		if ( logger == null ) {
	//			synchronized (logger) {
	//				if ( logger == null ) {
	//					logger = new SimpleLogger();
	//				}
	//			}
	//		}
	//		return logger;
	//	}

	//	method 5 
	//	private static volatile logger = new SimpleLogger();

	//	In the below code, we are having a private static inner class SingletonInner and having private field.
	//	Through, getInstance() method of singleton class, we will access the field of inner class, and due to being inner class, it will 
	//	be loaded only one time at the time of accessing the INSTANCE field first time. And the INSTANCE is a static member due to which it will be initialized only once.

	//    Classes are loaded only one time in memory by JDK.
	//    Inner classes in java are loaded in memory by JDK when it comes into scope of usage. 
	//    It means that if we are not performing any action with inner class in our codebase, 
	//    JDK will not load that inner class into memory. It is loaded only when this is being used somewhere. 

	//	private static class InnerClass {
	//
	//		private static final SimpleLogger INSTANCE = new SimpleLogger();
	//	}
	//
	//	public static SimpleLogger getInstance() {
	//		return InnerClass.INSTANCE;
	//	}

	@Override
	public void log( String log, String service ) {
		System.out.println( "Logging for service : " + service + " - log :" + log );
		FileWriter writter = null;
		try {
			if ( !file.exists() ) {
				file.createNewFile();
			}
			writter = new FileWriter( file, true );
			writter.append( service + " - " + log + " \n" );
			writter.close();
		}
		catch ( IOException e ) {
			e.printStackTrace();
		}
		finally {
			try {
				writter.close();
			}
			catch ( IOException e ) {
				e.printStackTrace();
			}
		}
	}

}
