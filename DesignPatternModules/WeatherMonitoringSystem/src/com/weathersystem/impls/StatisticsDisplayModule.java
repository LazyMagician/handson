package com.weathersystem.impls;

import java.util.Date;
import java.util.Map;

public class StatisticsDisplayModule extends DisplayModule {

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
		System.out.println( "Minimum Temperature : " + weatherDetails.get( "min_tmp" ) );
		System.out.println( "Maximum Temperature : " + weatherDetails.get( "max_tmp" ) );
		System.out.println( "Average Temperature : " + weatherDetails.get( "avg_tmp" ) );
		System.out.println( "-------------------" );
	}

}
