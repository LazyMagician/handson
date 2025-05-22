package com.smartshipping.interfaces;

public interface ShippingStrategy {

	public double calculateShippingCost( double initialAmount, int size );
}
