package com.gatewayexample.payment.products;

import com.gatewayexample.payment.interfaces.PaymentProcessor;

public class CreditCardPaymentProcessor implements PaymentProcessor {

	@Override
	public boolean performTrasaction( String userDetails, long amount, int type ) {
		System.out.println( "******** Performing Credit Card transaction ********" );
		System.out.println( "User : " + userDetails + "\n Amount: " + amount + " \n Type: " + type );
		return false;
	}

}
