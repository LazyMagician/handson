package com.smartshipping.client.impls;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.smartshipping.interfaces.ShippingContext;
import com.smartshipping.strategy.impls.ExpressShipping;
import com.smartshipping.strategy.impls.FreeShipping;
import com.smartshipping.strategy.impls.StandardShipping;

public class SmartShippingMain {

	public static void main( String[] args ) {
		Map<String, Integer> productVsCost;
		Scanner sc = new Scanner( System.in );
		ShippingContext context = new EcomClient( new StandardShipping() );
		boolean addProduct = true;
		while ( true ) {
			productVsCost = new HashMap<String, Integer>();
			do {
				System.out.println( "Enter product name : " );
				String product = sc.next();
				System.out.println( "Enter cost of product : " );
				int cost = sc.nextInt();
				System.out.println( "Enter number of product : " );
				int no = sc.nextInt();
				productVsCost.put( product, cost * no );
				System.out.println( "would you like to add more \n 1. Add more \n 2. Proceed to pay" );
				addProduct = sc.nextInt() == 1 ? true : false;
			}
			while ( addProduct );
			System.out.println( "Select shipping option as per your need: \n 1. Standard \n 2. Express \n 3. Free " );
			int option = sc.nextInt();
			switch( option ) {
			case 1:
				context.setShippingStrategy( new StandardShipping() );
				context.calculateTotalCost( productVsCost, 30 );
				break;
			case 2:
				context.setShippingStrategy( new ExpressShipping() );
				context.calculateTotalCost( productVsCost, 100 );
				break;
			case 3:
				context.setShippingStrategy( new FreeShipping() );
				context.calculateTotalCost( productVsCost, 20 );
				break;

			default:
				//				it will select the last opted
				context.calculateTotalCost( productVsCost, 30 );
				break;
			}
			System.out.println( "Would you like to purchase more  y/n" );
			String proceed = sc.next();
			if ( proceed.equalsIgnoreCase( "n" ) ) {
				break;
			}
		}
	}
}
