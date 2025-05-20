package com.weathersystem.interfaces;

import java.util.Map;

public interface ObserverModule {

	public Integer getId();

	public void update( Map<String, String> stateMap );

	public void display();
}
