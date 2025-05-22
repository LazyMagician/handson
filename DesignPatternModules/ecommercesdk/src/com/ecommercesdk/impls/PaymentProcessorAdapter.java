package com.ecommercesdk.impls;

import com.ecommercesdk.interfaces.Gateway;
import com.ecommercesdk.interfaces.Processor;

public class PaymentProcessorAdapter implements Processor {

	//	I'm a adapter code who will call the sdk method
	private Gateway gateway;

	public PaymentProcessorAdapter( Gateway gateway ) {
		this.gateway = gateway;
	}

	@Override
	public void processPayment( long amount ) {
		System.out.println( "I need to call our legacy sdk code to transact" );
		gateway.makeTransaction( amount );
	}

}
