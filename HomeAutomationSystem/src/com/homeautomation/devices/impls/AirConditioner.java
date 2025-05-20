package com.homeautomation.devices.impls;

import com.homeautomation.interfaces.Device;

public class AirConditioner extends Device {

	private double temp;

	//	Functions 
	public void setTemperature( double temp ) {
		if ( power ) {
			System.out.println( "Adjusting temperature to : " + temp + " degree celcius" );
			this.temp = temp;
		}
		else {
			System.out.println( "No power!!" );
		}
	}

	public String getTemperatureData() {
		if ( temp < 10 ) {
			return "VERY COOL";
		}
		else if ( temp > 10 && temp < 20 ) {
			return "COOL";
		}
		else {
			return "HOT";
		}
	}

	@Override
	protected void reset() {
		temp = 0;
	}

}
