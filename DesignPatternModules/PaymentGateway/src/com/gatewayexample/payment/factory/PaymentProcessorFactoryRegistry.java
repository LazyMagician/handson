package com.gatewayexample.payment.factory;

import java.util.HashMap;
import java.util.Map;

import com.gatewayexample.payment.interfaces.PaymentProcessorFactory;

public class PaymentProcessorFactoryRegistry {

	public static Map<String, PaymentProcessorFactory> registry = new HashMap<String, PaymentProcessorFactory>();

	public static boolean register( String methodType, PaymentProcessorFactory processorFactory ) {
		if ( methodType != null && !methodType.isEmpty() && processorFactory != null ) {
			registry.put( methodType, processorFactory );
			System.out.println( "Registered " + methodType + " with the central repo" );
			return true;
		}
		return false;

	}
}
