package com.weathersystem.impls;

import java.util.HashMap;
import java.util.Map;

import com.weathersystem.interfaces.CentralSystem;
import com.weathersystem.interfaces.ObserverModule;

public class WeatherMonitoringSytem implements CentralSystem {

	private Map<Integer, ObserverModule> observers;

	private Map<String, String> weatherDetails;

	private int observerId = 1;

	public WeatherMonitoringSytem( Map<String, String> weatherDetails ) {
		observers = new HashMap<Integer, ObserverModule>();
		setWeatherDetails( weatherDetails );
	}

	public void setWeatherDetails( Map<String, String> weatherDetails ) {
		this.weatherDetails = weatherDetails;
		notify( weatherDetails );
	}

	@Override
	public void updateStateParameter( String parameter, String value ) {
		System.out.println( "Updating parameter " + parameter + " in the weather system" );
		weatherDetails.put( parameter, value );
		notify( weatherDetails );
	}

	@Override
	public void addObserver( ObserverModule observer ) {
		System.out.println( "Adding observer " + observerId++ + " " );
		observers.put( observerId, observer );
	}

	@Override
	public void removeObserver( ObserverModule observer ) {
		System.out.println( "Removing observer " + observer.getId() );
		observers.remove( observer.getId() );
	}

	@Override
	public void notify( Map<String, String> weatherDetails ) {
		observers.values().stream().forEach( obs -> obs.update( weatherDetails ) );
	}

}
