package com.pizzarest.client.impls;

import com.pizzarest.builder.impls.PepperoniSkilledChef;
import com.pizzarest.builder.impls.Pizza;
import com.pizzarest.builder.interfaces.Chef;
import com.pizzarest.builder.interfaces.Manager;
import com.pizzarest.client.interfaces.Client;
import com.pizzarest.manager.impls.PizzaManager;

public class HungryClient implements Client {

	@Override
	public Pizza giveMePizza() {
		Chef chef = new PepperoniSkilledChef();
		Manager manager = new PizzaManager( chef );
		manager.makePizza();
		Pizza pizza = chef.getPizza();
		return pizza;
	}

}
