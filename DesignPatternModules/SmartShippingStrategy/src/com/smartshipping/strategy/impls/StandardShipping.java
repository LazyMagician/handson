package com.smartshipping.strategy.impls;

import com.smartshipping.interfaces.ShippingStrategy;

public class StandardShipping implements ShippingStrategy {

	private int stdPrice = 150;

	@Override
	public double calculateShippingCost( double initialAmount, int size ) {
		System.out.println( "Proceeding with standard shipping" );
		System.out.println( "Calculating total cost ..." );
		return stdPrice * size;
	}

}
