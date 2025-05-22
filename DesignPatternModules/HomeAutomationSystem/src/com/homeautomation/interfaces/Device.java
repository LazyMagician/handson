package com.homeautomation.interfaces;

public abstract class Device {

	protected boolean power;

	protected String device;

	public void turnOn() {
		System.out.println( "Turning on the " + device );
		power = true;
	}

	public void turnOff() {
		System.out.println( "Switching off the " + device );
		power = false;
		reset();
	}

	public String getDevice() {
		return device;
	}

	public void setDevice( String device ) {
		this.device = device;
	}

	protected abstract void reset();

}
