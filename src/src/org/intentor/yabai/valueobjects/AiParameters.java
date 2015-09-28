package org.intentor.yabai.valueobjects;

import lejos.nxt.MotorPort;
import lejos.nxt.SensorPort;
import org.intentor.yabai.constants.BoundaryColor;

/**
 * AI parameters.
 */
public class AiParameters {
	/** Left motor port. */
	public MotorPort motorLeft;
	/** Right motor port. */
	public MotorPort motorRight;
	/** Light sensor port. */
	public SensorPort sensorLight;
	/** Ultrasonic sensor port. */
	public SensorPort sensorUltrasonic;
	/** Touch sensor port. */
	public SensorPort sensorTouch;
	/** Timer to start the AI (seconds). */
	public int timer;
	/** Boundary color. */
	public String color;
	/** Detection distance. */
	public int detectionDistance;
	/** Forward speed (degrees). */
	public int speedForward;
	/** Backward speed (degrees). */
	public int speedBackward;
	/** Rotation speed (degrees). */
	public int speedRotation;
	
	/**
	 * Creates the default parameters.
	 * 
	 * @return The default parameters.
	 */
	public static AiParameters Default() {
		AiParameters parameters = new AiParameters();
		
		parameters.motorLeft = MotorPort.A;
		parameters.motorRight = MotorPort.B;
		parameters.sensorLight = SensorPort.S1;
		parameters.sensorUltrasonic = SensorPort.S2;
		parameters.sensorTouch = SensorPort.S3;
		parameters.timer = 5;
		parameters.color = BoundaryColor.WHITE;
		parameters.detectionDistance = 30;
		parameters.speedForward = 1440;
		parameters.speedBackward = 1440;
		parameters.speedRotation = 1080;
		
		return parameters;
	}
}
