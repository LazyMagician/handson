package com.homeautomation.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import com.homeautomation.interfaces.Remote;
import com.homeautomation.remote.impls.RemoteControl;

public class HomeAutomationMain {

	public static void main( String[] args ) {
		int command;
		Remote remote = new RemoteControl();
		Scanner sc = new Scanner( System.in );
		while ( true ) {
			System.out.println( "Choose a command : \n 1. Leave Home \n 2. Enter Home \n 3. Watch Movie \n 4. Wake Up " );
			System.out.println( " 5. Activate Sleep Mode \n 6. Activate Vacation Mode \n 7. Activate Emergency Mode \n 8. Exit" );
			command = sc.nextInt();
			switch( command ) {
			case 1:
				remote.leaveHome();
				break;
			case 2:
				remote.enterHome();
				break;
			case 3:
				remote.watchMovie();
				break;
			case 4:
				remote.wakeUp();
				break;
			case 5:
				remote.activateSleepMode();
				break;
			case 6:
				remote.activateVacationMode();
				break;
			case 7:
				remote.activateEmergencyMode();
				break;
			case 8:
				System.exit( 1 );
			default:
				System.out.println( "Please enter a valid code" );
				break;
			}
		}
	}

}
