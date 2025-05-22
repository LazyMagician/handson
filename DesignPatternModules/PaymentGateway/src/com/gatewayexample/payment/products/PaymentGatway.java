package com.gatewayexample.payment.products;

import java.util.HashMap;
import java.util.Map;

import com.gatewayexample.payment.factory.MainPaymentProcessorFactory;
import com.gatewayexample.payment.interfaces.PaymentProcessor;

public class PaymentGatway {

	private String name;

	private String apiKey;

	private String[] supportedMethods;

	private Map<String, PaymentProcessor> processorRegistry = new HashMap<String, PaymentProcessor>();

	public PaymentGatway( String name, String apiKey, String[] supportedMethods ) {
		this.name = name;
		this.apiKey = apiKey;
		this.supportedMethods = supportedMethods;
		initialize();
	}

	private void initialize() {
		intializePaymentMethods( supportedMethods );

	}

	private void intializePaymentMethods( String[] methods ) {
		MainPaymentProcessorFactory processorFactory = new MainPaymentProcessorFactory();
		for ( String method : methods ) {
			PaymentProcessor processor = processorFactory.createPaymentProcessor( method );
			processorRegistry.put( method, processor );
		}
	}

	public boolean pay( String user, long amount, int type, String method ) {
		PaymentProcessor processor = processorRegistry.get( method );
		return processor.performTrasaction( user, amount, type );
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey( String apiKey ) {
		this.apiKey = apiKey;
	}

}
