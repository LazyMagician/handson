package com.pizzarest.manager.impls;

import com.pizzarest.builder.interfaces.Chef;
import com.pizzarest.builder.interfaces.Manager;

public class PizzaManager implements Manager {

	private Chef chef;

	public PizzaManager( Chef chef ) {
		this.chef = chef;
	}

	@Override
	public void makePizza() {
		System.out.println( "Manager: Hey Chef make a pizza, and follow my steps" );
		chef.setSize();
		chef.setCrust();
		chef.addSauce();
		System.out.println( "Manager: Pizza will be on your table in 5 more mins sir" );
		chef.addToppings();
		System.out.println( "Manager: Good work chef" );

	}
}
