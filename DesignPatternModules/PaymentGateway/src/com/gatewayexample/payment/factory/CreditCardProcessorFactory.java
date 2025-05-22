package com.gatewayexample.payment.factory;

import com.gatewayexample.payment.interfaces.PaymentProcessor;
import com.gatewayexample.payment.interfaces.PaymentProcessorFactory;
import com.gatewayexample.payment.products.CreditCardPaymentProcessor;

public class CreditCardProcessorFactory implements PaymentProcessorFactory {

	@Override
	public PaymentProcessor createPaymentProcessor() {
		return new CreditCardPaymentProcessor();
	}

}
