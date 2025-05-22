package com.homeautomation.devices.impls;

import com.homeautomation.interfaces.Device;

public class Television extends Device {

	private boolean connected;

	private int contrast;

	private int brightness;

	private int sharpness;

	//	Functions
	public void connectToInternet() {
		System.out.println( "Connected to internet successfully ... " );
		connected = true;
	}

	public void adjustSettings( int contrast, int brightness, int sharpness ) {
		this.brightness = brightness;
		this.contrast = contrast;
		this.sharpness = sharpness;
	}

	public void openOTTApps() {
		if ( connected ) {
			System.out.println( "Opening OTT apps" );
		}
		else {
			System.out.println( "Please connect to internet to stream OTT apps" );
		}
	}

	public void getTVDetails() {
		System.out.println( "------- TV  Stats -------" );
		System.out.println( "CONTRAST : " + contrast );
		System.out.println( "BRIGHTNESS : " + brightness );
		System.out.println( "SHARPNESS : " + sharpness );
		System.out.println( "-------------------------" );
	}

	@Override
	protected void reset() {
		connected = false;
		brightness = 0;
		contrast = 0;
		sharpness = 0;

	}

}
