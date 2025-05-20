package com.gatewayexample.payment.factory;

import com.gatewayexample.payment.interfaces.PaymentProcessor;
import com.gatewayexample.payment.interfaces.PaymentProcessorFactory;

public class MainPaymentProcessorFactory {

	public PaymentProcessor createPaymentProcessor( String type ) {
		PaymentProcessorFactory factory = PaymentProcessorFactoryRegistry.registry.get( type );
		return factory.createPaymentProcessor();
	}
}
