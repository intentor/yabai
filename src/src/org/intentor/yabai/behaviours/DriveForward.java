package org.intentor.yabai.behaviours;

import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;

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
	/** Ultrasonic sensor. */
	private final UltrasonicSensor sonar;
	/** Detection distance to take control. */
	private final int detectDistance;
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param motorLeftPort Motor left port.
	 * @param motorRightPort Motor right port.
	 * @param speed Driving speed.
	 * @param sonarPort Ultrasonic sensor port.
	 * @param detectDistance Detection distance to take control.
	 */
	public DriveForward(MotorPort motorLeftPort, MotorPort motorRightPort, int speed, SensorPort sonarPort, int detectDistance) {
		this.motorLeft = Motor.getInstance(motorLeftPort.getId());
		this.motorRight = Motor.getInstance(motorRightPort.getId());
		this.speed = speed;
		this.sonar = new UltrasonicSensor(sonarPort);
		this.detectDistance = detectDistance;
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
		this.motorLeft.forward();
		this.motorRight.forward();
		
		while (!this.suppressed) {
			LCD.drawString("Forward...", 0, 3);
			Thread.yield();
		}
	}
}
