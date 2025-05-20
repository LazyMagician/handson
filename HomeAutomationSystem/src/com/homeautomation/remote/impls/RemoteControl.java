package com.homeautomation.remote.impls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.homeautomation.devices.impls.AirConditioner;
import com.homeautomation.devices.impls.Light;
import com.homeautomation.devices.impls.SecurityCamera;
import com.homeautomation.devices.impls.Television;
import com.homeautomation.interfaces.Device;
import com.homeautomation.interfaces.Remote;

public class RemoteControl implements Remote {

	private AirConditioner ac;

	private Television tv;

	private SecurityCamera camera;

	private Light light;

	private List<Device> devices = new ArrayList<Device>();

	public RemoteControl() {
		ac = new AirConditioner();
		ac.setDevice( "AC" );
		tv = new Television();
		tv.setDevice( "TV" );
		camera = new SecurityCamera();
		camera.setDevice( "Camera" );
		light = new Light();
		light.setDevice( "Light" );
		devices.addAll( Arrays.asList( ac, tv, camera, light ) );
	}

	@Override
	public boolean leaveHome() {
		System.out.println( "Leaving home ..." );
		try {
			for ( Device device : devices ) {
				device.turnOff();
			}
			camera.turnOn();
		}
		catch ( Exception e ) {
			System.out.println( "Error occurred while performing instructions to leave home " + e );
			return false;
		}
		return true;
	}

	@Override
	public boolean enterHome() {
		System.out.println( "Entering home ..." );
		try {
			for ( Device device : devices ) {
				device.turnOn();
			}
			camera.turnOn();
		}
		catch ( Exception e ) {
			System.out.println( "Error occurred while performing instructions to enter  home " + e );
			return false;
		}
		return true;
	}

	@Override
	public boolean watchMovie() {
		System.out.println( "Executing watch movie instructions" );
		try {
			light.turnOn();
			light.adjustIntensity( 50 );
			ac.setTemperature( 22 );
			tv.turnOn();
			tv.connectToInternet();
			tv.adjustSettings( 40, 50, 50 );
			tv.getTVDetails();
			tv.openOTTApps();
		}
		catch ( Exception e ) {
			System.out.println( "Error occurred while performing instructions to watch  movie" + e );
			return false;

		}
		return true;
	}

	@Override
	public boolean wakeUp() {
		System.out.println( "Wake up" );
		try {
			light.turnOff();
			ac.setTemperature( 25 );
			camera.getTotalHoursRecorded();
		}
		catch ( Exception e ) {
			System.out.println( "Error occurred while executing waking up instruction" + e );
			return false;
		}
		return true;
	}

	@Override
	public boolean activateSleepMode() {
		System.out.println( "Activating sleep mode" );
		try {
			light.turnOff();
			ac.setTemperature( 22 );
			tv.turnOff();
			camera.turnOn();
			camera.setTotalHoursRecorded( 40 );
		}
		catch ( Exception e ) {
			System.out.println( "Error occurred while executing sleep mode instruction" + e );
			return false;
		}
		return true;
	}

	@Override
	public boolean activateVacationMode() {
		System.out.println( "Activating sleep mode" );
		try {
			leaveHome();
			camera.setTotalHoursRecorded( 70 );
		}
		catch ( Exception e ) {
			System.out.println( "Error occurred while executing vacation mode instruction" + e );
			return false;
		}
		return true;
	}

	@Override
	public boolean activateEmergencyMode() {
		System.out.println( "Activating Emergency  mode" );
		try {
			camera.getCameraDetails();
			camera.getTotalHoursRecorded();
			System.out.println( "Calling 911" );
			light.adjustIntensity( 911 );
			ac.turnOff();
		}
		catch ( Exception e ) {
			System.out.println( "Error occurred while executing emergency mode" + e );
			System.out.println( "Calling 911 " );
			System.out.println( "Start siren" );
			return false;
		}
		return true;
	}

}
