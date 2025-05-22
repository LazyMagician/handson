package com.gatewayexample.main;

import com.gatewayexample.payment.factory.CreditCardProcessorFactory;
import com.gatewayexample.payment.factory.PaymentProcessorFactoryRegistry;
import com.gatewayexample.payment.factory.UPIProcessorFactory;
import com.gatewayexample.payment.factory.WalletProcessorFactory;
import com.gatewayexample.payment.products.PaymentGatway;

public class PaymentSimulationMain {

	public static void main( String[] args ) {
		registerToMainRegistry();
		PaymentGatway gateway = new PaymentGatway( "Stripe", "ananthu123", new String[] { "upi", "credit_card" } );
		//		pay using credit_card
		gateway.pay( "ananthu", 100, 1, "credit_card" );
		//		pay using upi
		gateway.pay( "ananthu upi", 100, 1, "upi" );

	}

	private static void registerToMainRegistry() {
		PaymentProcessorFactoryRegistry.register( "upi", new UPIProcessorFactory() );
		PaymentProcessorFactoryRegistry.register( "credit_card", new CreditCardProcessorFactory() );
		PaymentProcessorFactoryRegistry.register( "wallet", new WalletProcessorFactory() );
	}

}
