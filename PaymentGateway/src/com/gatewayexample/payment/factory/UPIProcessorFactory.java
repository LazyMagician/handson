package com.gatewayexample.payment.factory;

import com.gatewayexample.payment.interfaces.PaymentProcessor;
import com.gatewayexample.payment.interfaces.PaymentProcessorFactory;
import com.gatewayexample.payment.products.UPIPaymentProcessor;

public class UPIProcessorFactory implements PaymentProcessorFactory {

	@Override
	public PaymentProcessor createPaymentProcessor() {
		return new UPIPaymentProcessor();
	}

}
