package com.homeautomation.devices.impls;

import com.homeautomation.interfaces.Device;

public class Light extends Device {

	int intensity;

	public void adjustIntensity( int intensity ) {
		this.intensity = intensity;
	}

	@Override
	protected void reset() {
		intensity = 0;
	}

}
