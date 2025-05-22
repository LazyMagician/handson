package com.logging.main;

import java.util.Date;

import com.loggingsystem.impls.PaymentService;
import com.loggingsystem.interfaces.Service;

public class LogginSystemSimulationMain {

	public static void main( String[] args ) {
		System.out.println( "Let see guys" );
		Service paymentService = new PaymentService();
		paymentService.start();
		Date startDate = new Date();
		long startTime = startDate.getTime();
		while ( true ) {
			if ( new Date().getTime() - startTime == 1 * 60 * 1000 ) {
				System.out.println( new Date() + " " + startDate );
				paymentService.stop();
				break;
			}
		}
	}
}
