package com.weathersystem.impls;

import java.util.Date;
import java.util.Map;

public class ForecastDisplayModule extends DisplayModule {

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
		System.out.println( "Previous Pressure : " + weatherDetails.get( "prev_pressure" ) );
		System.out.println( "Current Pressure : " + weatherDetails.get( "curr_pressure" ) );
		System.out.println( "-------------------" );
	}

}
