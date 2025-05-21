package com.smartshipping.client.impls;

import java.util.Map;

import com.smartshipping.interfaces.ShippingContext;
import com.smartshipping.interfaces.ShippingStrategy;

public class EcomClient implements ShippingContext {

	private ShippingStrategy strategy;

	public EcomClient( ShippingStrategy strategy ) {
		this.strategy = strategy;
	}

	@Override
	public void setShippingStrategy( ShippingStrategy strategy ) {
		this.strategy = strategy;
	}

	@Override
	public void calculateTotalCost( Map<String, Integer> productVsCost, double tax ) {
		double cost = 0;
		String bill = "------------------------------------------ \n";
		bill += "   BILL   \n";
		bill += "------------------------------------------ \n";
		int index = 1;
		for ( String product : productVsCost.keySet() ) {
			bill += index + ". " + product + " - " + productVsCost.get( product ) + "\n";
			cost += productVsCost.get( product );
			index++;
		}
		cost += tax;
		int size = 0;
		if ( index > 10 ) {
			size = 60;
		}
		else {
			size = 10;
		}
		double shippingCost = strategy.calculateShippingCost( cost, size );
		cost += shippingCost;
		bill += "------------------------------------------ \n";
		bill += "Tax               -  " + tax + "\n";
		bill += "Shipping Charge   -  " + shippingCost + "\n";
		bill += "------------------------------------------ \n";
		bill += "Total             -  " + cost + "\n";
		bill += "------------------------------------------ \n";

		System.out.println( bill );
	}

}
