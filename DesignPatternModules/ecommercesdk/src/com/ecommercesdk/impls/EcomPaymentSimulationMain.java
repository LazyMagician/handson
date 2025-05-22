package com.ecommercesdk.impls;

import com.ecommercesdk.interfaces.Client;
import com.ecommercesdk.interfaces.Gateway;
import com.ecommercesdk.interfaces.Processor;

public class EcomPaymentSimulationMain {
	public static void main( String[] args ) {
        Gateway gateway = new PaymentGatewaySdk();
		Processor processor = new PaymentProcessorAdapter( gateway );
		Client client = new EcomClient( processor );
		client.performTransaction( 1000 );
	}

}
