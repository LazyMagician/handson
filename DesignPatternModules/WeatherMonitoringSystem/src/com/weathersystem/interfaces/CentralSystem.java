package com.weathersystem.interfaces;

import java.util.Map;

public interface CentralSystem {

	public void addObserver( ObserverModule observer );

	public void removeObserver( ObserverModule observer );

	public void notify( Map<String, String> stateMap );

	public void updateStateParameter( String parameter, String value );
}
