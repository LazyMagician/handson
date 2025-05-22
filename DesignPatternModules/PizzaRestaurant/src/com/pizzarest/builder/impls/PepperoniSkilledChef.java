package com.pizzarest.builder.impls;

import com.pizzarest.builder.interfaces.Chef;

public class PepperoniSkilledChef implements Chef {

	private Pizza pizza;

	public PepperoniSkilledChef() {
		pizza = new Pizza();
		pizza.setName( "Pepperoni Deluxe Pizza" );

	}

	@Override
	public void setSize() {
		System.out.println( "Chef : Boss, setting the size" );
		pizza.setSize( "Large" );
	}

	@Override
	public void setCrust() {
		System.out.println( "Chef : Boss, making the chessy crust " );
		pizza.setCurst( "Cheese-stuffed crust" );

	}

	@Override
	public void addSauce() {
		System.out.println( "Chef : Boss, adding some delicious sauce" );
		pizza.setSauce( "Spicy tomato" );
	}

	@Override
	public void addToppings() {
		System.out.println( "Chef : Ok Boss, nice toppings combo, adding toppings" );
		pizza.setToppings( "Pepperoni, extra cheese, olives, mushrooms" );
	}

	@Override
	public Pizza getPizza() {
		System.out.println( "Chef: Here's your delicious pizza bro " );
		return pizza;
	}

}
