package org.intentor.yabai.behaviours;

import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;

/**
 * Searches for a target.
 */
public class Searching implements Behavior {
	/** Indicates whether the behaviour has been supressed. */
	private boolean suppressed = false;
	/** Left motor. */
	private final NXTRegulatedMotor motorLeft;
	/** Right motor. */
	private final NXTRegulatedMotor motorRight;
	/** Rotation speed to be applied to the motors. */
	private final int rotationSpeed;
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param motorLeftPort Motor left port.
	 * @param motorRightPort Motor right port.
	 * @param rotationSpeed Rotation speed to be applied to the motors.
	 */
	public Searching(MotorPort motorLeftPort, MotorPort motorRightPort, int rotationSpeed) {
		this.motorLeft = Motor.getInstance(motorLeftPort.getId());
		this.motorRight = Motor.getInstance(motorRightPort.getId());
		this.rotationSpeed = rotationSpeed;
	}

	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void suppress() {
		this.suppressed = true;
	}

	@Override
	public void action() {
		this.suppressed = false;
		
		this.motorLeft.setSpeed(this.rotationSpeed);
		this.motorRight.setSpeed(this.rotationSpeed);
		this.motorLeft.forward();
		this.motorRight.backward();
		
		while (!this.suppressed) {
			LCD.drawString("Searching...", 0, 3);
			Thread.yield();
		}
	}
}
