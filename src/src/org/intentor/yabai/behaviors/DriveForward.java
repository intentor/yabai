package org.intentor.yabai.behaviors;

import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;
import org.intentor.yabai.util.DataConverter;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Drives the robot forward.
 */
public class DriveForward implements Behavior {
	/** Indicates whether the behaviour has been supressed. */
	private boolean suppressed = false;
	/** Left motor. */
	private final NXTRegulatedMotor motorLeft;
	/** Right motor. */
	private final NXTRegulatedMotor motorRight;
	/** Driving speed. */
	private final int speed;
	/** Driving direction (F/B). */
	private final char direction;
	/** Ultrasonic sensor. */
	private final UltrasonicSensor sonar;
	/** Detection distance to take control. */
	private final int detectDistance;
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param parameters AI parameters to configure the behaviour.
	 */
	public DriveForward(AiParameters parameters) {
		MotorPort motorLeftPort = DataConverter.motorPortFromChar(parameters.motorLeft);
		MotorPort motorRightPort = DataConverter.motorPortFromChar(parameters.motorRight);
		SensorPort sonarPort = DataConverter.sensorPortFromInt(parameters.sensorUltrasonic);
		
		this.motorLeft = Motor.getInstance(motorLeftPort.getId());
		this.motorRight = Motor.getInstance(motorRightPort.getId());
		this.speed = parameters.speedForward;
		this.direction = parameters.forward;
		this.sonar = new UltrasonicSensor(sonarPort);
		this.detectDistance = parameters.detectionDistance;
	}

	@Override
	public boolean takeControl() {
		return (this.sonar.getDistance() <= this.detectDistance);
	}

	@Override
	public void suppress() {
		this.suppressed = true;
	}

	@Override
	public void action() {
		this.suppressed = false;
		
		this.motorLeft.setSpeed(this.speed);
		this.motorRight.setSpeed(this.speed);
		
		if (this.direction == 'F') {
			this.motorLeft.forward();
			this.motorRight.forward();
		} else {
			this.motorLeft.backward();
			this.motorRight.backward();
		}
		
		while (!this.suppressed && this.sonar.getDistance() <= this.detectDistance) {
			LCD.drawString("Forward...", 0, 3);
			Thread.yield();
		}
	}
}