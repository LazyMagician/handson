package com.smartshipping.strategy.impls;

import com.smartshipping.interfaces.ShippingStrategy;

public class FreeShipping implements ShippingStrategy {

	@Override
	public double calculateShippingCost( double initialAmount, int size ) {
		System.out.println( "Proceeding with free shipping" );
		System.out.println( "Calculating total cost ..." );
		return 0;
	}

}
