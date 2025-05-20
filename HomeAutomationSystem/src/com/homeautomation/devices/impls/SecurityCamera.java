package com.homeautomation.devices.impls;

import com.homeautomation.interfaces.Device;

public class SecurityCamera extends Device {

	int totalHoursRecorded;

	public void setTotalHoursRecorded( int totalHoursRecorded ) {
		this.totalHoursRecorded = totalHoursRecorded;
	}

	public int getTotalHoursRecorded() {
		return totalHoursRecorded;
	}

	public void getCameraDetails() {
		System.out.println( "--------- Camera Details ---------" );
		System.out.println( "Total hours : " + totalHoursRecorded );
	}

	@Override
	protected void reset() {
		totalHoursRecorded = 0;
	}

}
