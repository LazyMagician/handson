package com.loggingsystem.impls;

import java.util.Date;

import com.loggingsystem.interfaces.Service;

public class PaymentService implements Service, Runnable {

	private Thread thread;

	@Override
	public void start() {
		thread = new Thread( this );
		thread.start();
	}

	@Override
	public void stop() {
		System.out.println( "Stoping Payment Thread" );
		thread.interrupt();
	}

	@Override
	public String getName() {
		return "Payment Service";
	}

	@Override
	public void run() {
		System.out.println( "Starting Payment Thread" );
		long startTime = new Date().getTime();
		long fiveMinInMillis = 5 * 60 * 1000;
		long oneMinInMillis = 1 * 60 * 1000;
		long endTime = new Date( startTime + fiveMinInMillis ).getTime();
		while ( new Date().getTime() < endTime ) {
			try {
				int noOfTime = 5;
				while ( noOfTime > 0 ) {
					SimpleLogger.getInstance().log( "Payment transaction " + noOfTime, getName() );
					noOfTime--;
				}
				Thread.sleep( oneMinInMillis );
			}
			catch ( InterruptedException e ) {
				System.out.println( "Thread was interrupted" );
				break;
			}
		}
	}

}
