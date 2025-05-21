package com.smartshipping.interfaces;

import java.util.Map;

public interface ShippingContext {

	public void setShippingStrategy( ShippingStrategy strategy );

	public void calculateTotalCost( Map<String, Integer> productVsCost, double tax );
}
