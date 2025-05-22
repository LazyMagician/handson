package com.pizzarest.builder.impls;

import com.pizzarest.builder.interfaces.Chef;

public class MargheritaSkilledChef implements Chef {

	Pizza pizza = new Pizza();

	public MargheritaSkilledChef() {
		pizza = new Pizza();
		pizza.setName( "Margherita Pizza" );

	}

	@Override
	public void setSize() {
		System.out.println( "Chef: Ok Boss, setting the size" );
		pizza.setSize( "Medium" );
	}

	@Override
	public void setCrust() {
		System.out.println( "Chef: Ok Boss, making the crust " );
		pizza.setCurst( "Thin Crust" );

	}

	@Override
	public void addSauce() {
		System.out.println( "Chef: Ok Boss, adding some delicious sauce" );
		pizza.setSauce( "Tomato basil" );
	}

	@Override
	public void addToppings() {
		System.out.println( "Chef: Ok Boss, nice toppings combo, adding toppings" );
		pizza.setToppings( "Mozzarella cheese, fresh basil, olive oil" );
	}

	@Override
	public Pizza getPizza() {
		System.out.println( "Chef: Here's your pizza bro " );
		return pizza;
	}

}
