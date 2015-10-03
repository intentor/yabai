package org.intentor.yabai.behaviours;

import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;

/**
 * Drives the robot backward.
 */
public class DriveBackward implements Behavior {
	/** Indicates whether the behaviour has been supressed. */
	private boolean suppressed = false;
	/** Left motor. */
	private final NXTRegulatedMotor motorLeft;
	/** Right motor. */
	private final NXTRegulatedMotor motorRight;
	/** Driving speed. */
	private final int speed;
	/** Driving direction (F/B). */
	private char direction;
	/** Touch sensor. */
	private final TouchSensor touch;
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param motorLeftPort Motor left port.
	 * @param motorRightPort Motor right port.
	 * @param speed Driving speed.
	 * @param direction Driving direction (F/B).
	 * @param touchPort Touch sensor port.
	 */
	public DriveBackward(MotorPort motorLeftPort, MotorPort motorRightPort, int speed, char direction, SensorPort touchPort) {
		this.motorLeft = Motor.getInstance(motorLeftPort.getId());
		this.motorRight = Motor.getInstance(motorRightPort.getId());
		this.speed = speed;
		this.direction = direction;
		this.touch = new TouchSensor(touchPort);
	}

	@Override
	public boolean takeControl() {
		return this.touch.isPressed();
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
			this.motorLeft.backward();
			this.motorRight.backward();
		} else {
			this.motorLeft.forward();
			this.motorRight.forward();
		}
		
		while (!this.suppressed && this.touch.isPressed()) {
			LCD.drawString("Backward...", 0, 3);
			Thread.yield();
		}
	}
}
