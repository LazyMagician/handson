package com.pizzarest.main;

import com.pizzarest.builder.impls.Pizza;
import com.pizzarest.client.impls.HungryClient;
import com.pizzarest.client.interfaces.Client;

public class PizzaRestaurantSimulationMain {

	public static void main( String[] args ) {
		System.out.println( "Welcome to Pizza Star Restaurant" );
		System.out.println( "--------------------------------" );
		
		Client consumer = new HungryClient();
		Pizza pizza = consumer.giveMePizza();
		System.out.println( "*******" + pizza.getName() + "*******" );
		System.out.println( " size : " + pizza.getSize() + " \n crust: " + pizza.getCurst() + " \n sauce: " + pizza.getSauce() + " \n toppings: " + pizza.getToppings() );
	}
}
