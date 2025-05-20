package com.weathersystem.main;

import java.util.HashMap;

import com.weathersystem.impls.CurrentConditionsDisplayModule;
import com.weathersystem.impls.ForecastDisplayModule;
import com.weathersystem.impls.StatisticsDisplayModule;
import com.weathersystem.impls.WeatherMonitoringSytem;
import com.weathersystem.interfaces.CentralSystem;
import com.weathersystem.interfaces.ObserverModule;

public class WeatherMonitoringSystemMain {

	public static void main( String[] args ) {
		ObserverModule conditionModule = new CurrentConditionsDisplayModule();
		ObserverModule statsModule = new StatisticsDisplayModule();
		ObserverModule forecastModule = new ForecastDisplayModule();

		CentralSystem monitorSystem = new WeatherMonitoringSytem( new HashMap<>() );
		monitorSystem.addObserver( conditionModule );
		monitorSystem.addObserver( statsModule );
		monitorSystem.addObserver( forecastModule );

		monitorSystem.updateStateParameter( "min_tmp", "24" );
		monitorSystem.updateStateParameter( "max_tmp", "35");
		monitorSystem.updateStateParameter( "curr_tmp", "23");
		
		
	}
}
