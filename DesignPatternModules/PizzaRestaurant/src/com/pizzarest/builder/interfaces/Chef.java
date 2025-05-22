package com.pizzarest.builder.interfaces;

import com.pizzarest.builder.impls.Pizza;

public interface Chef {


	public void setSize();

	public void setCrust();

	public void addSauce();

	public void addToppings();

	public Pizza getPizza();

}