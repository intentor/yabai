package org.intentor.yabai.util;

import lejos.nxt.MotorPort;
import lejos.nxt.SensorPort;

/**
 * Converts data between YAB AI and Lejos.
 */
public final class DataConverter {
	/**
	 * Converts a char to motor port.
	 * 
	 * @param port The port to convert from (A, B or C).
	 * @return The motor port.
	 */
	public static final MotorPort motorPortFromChar(char port) {
		if (port == 'B') {
			return MotorPort.B;
		} else if (port == 'C') {
			return MotorPort.C;
		} else {
			return MotorPort.A;
		}		
	}
	
	/**
	 * Converts a integer to sensor port.
	 * 
	 * @param port The port to convert from (1-4).
	 * @return The sensor port.
	 */
	public static final SensorPort sensorPortFromInt(int port) {
		switch (port) {
			case 1:
			default:
				return SensorPort.S1;
			case 2:
				return SensorPort.S2;
			case 3:
				return SensorPort.S3;
			case 4:
				return SensorPort.S4;
		}
	}
}
