package com.ecommercesdk.impls;

import com.ecommercesdk.interfaces.Gateway;

public class PaymentGatewaySdk implements Gateway {

	@Override
	public void makeTransaction( long amount ) {
		System.out.println( "I am legacy code with incompatible method maketransaction in client, use adapter to access me" );
		System.out.println( "**** Transaction " + amount + " successfull ****" );
	}

}
