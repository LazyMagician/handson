package com.smartshipping.strategy.impls;

import com.smartshipping.interfaces.ShippingStrategy;

public class ExpressShipping implements ShippingStrategy {

	private int expPrice = 100;

	@Override
	public double calculateShippingCost( double initialAmount, int size ) {
		System.out.println( "Proceeding with express shipping" );
		System.out.println( "Calculating total cost ..." );
		return  expPrice * size;
	}

}
