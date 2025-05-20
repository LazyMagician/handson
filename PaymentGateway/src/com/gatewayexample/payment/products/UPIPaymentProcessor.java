package com.gatewayexample.payment.products;

import com.gatewayexample.payment.interfaces.PaymentProcessor;

public class UPIPaymentProcessor implements PaymentProcessor {

	@Override
	public boolean performTrasaction( String userDetails, long amount, int type ) {
		System.out.println( "******** Performing UPI transaction ********" );
		System.out.println( "User : " + userDetails + "\n Amount: " + amount + " \n Type: " + type );
		return false;
	}

}
