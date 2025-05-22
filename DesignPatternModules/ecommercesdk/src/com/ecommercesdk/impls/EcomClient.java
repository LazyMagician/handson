package com.ecommercesdk.impls;

import com.ecommercesdk.interfaces.Client;
import com.ecommercesdk.interfaces.Processor;

public class EcomClient implements Client {

	private Processor processor;

	public EcomClient( Processor processor ) {
		this.processor = processor;
	}

	@Override
	public void performTransaction( long amount ) {
		System.out.println( "Pay " + amount + " to ecom to get the product" );
		processor.processPayment( amount );
	}

}
