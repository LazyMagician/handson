package com.gatewayexample.payment.interfaces;

public interface PaymentProcessor {

	public boolean performTrasaction( String userDetails, long amount, int type );
}