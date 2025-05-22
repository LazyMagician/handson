package com.weathersystem.impls;

import java.util.Date;
import java.util.Map;

public class CurrentConditionsDisplayModule extends DisplayModule {

	private Map<String, String> weatherDetails;

	@Override
	public void update( Map<String, String> weatherDetails ) {
		this.weatherDetails = weatherDetails;
		display();
	}

	@Override
	public void display() {
		System.out.println( "-------------------" );
		System.out.println( "Time :" + new Date().getDate() );
		System.out.println( "Temperature : " + weatherDetails.get( "curr_tmp" ) );
		System.out.println( "Humidity : " + weatherDetails.get( "humidity" ) );
		System.out.println( "-------------------" );
	}

}
