package com.gatewayexample.payment.factory;

import com.gatewayexample.payment.interfaces.PaymentProcessor;
import com.gatewayexample.payment.interfaces.PaymentProcessorFactory;
import com.gatewayexample.payment.products.WalletPaymentProcessor;

public class WalletProcessorFactory implements PaymentProcessorFactory {

	@Override
	public PaymentProcessor createPaymentProcessor() {
		return new WalletPaymentProcessor();
	}

}
