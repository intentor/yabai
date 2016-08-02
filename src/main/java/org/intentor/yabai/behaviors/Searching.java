package org.intentor.yabai.behaviors;

import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;
import org.intentor.yabai.constants.RotationDirection;
import org.intentor.yabai.util.DataConverter;
import org.intentor.yabai.valueobjects.AiParameters;

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
	/** Rotation direction. */
	private final char rotationDirection;
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param parameters AI parameters to configure the behaviour.
	 */
	public Searching(AiParameters parameters) {
		MotorPort motorLeftPort = DataConverter.motorPortFromChar(parameters.motorLeft);
		MotorPort motorRightPort = DataConverter.motorPortFromChar(parameters.motorRight);
		
		this.motorLeft = Motor.getInstance(motorLeftPort.getId());
		this.motorRight = Motor.getInstance(motorRightPort.getId());
		this.rotationSpeed = parameters.speedRotation;
		this.rotationDirection = parameters.rotation;
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
		
		if (this.rotationDirection == RotationDirection.LEFT) {
			this.motorLeft.forward();
			this.motorRight.backward();
		} else {
			this.motorLeft.backward();
			this.motorRight.forward();
		}
		
		while (!this.suppressed) {
			LCD.drawString("Searching...", 0, 3);
			Thread.yield();
		}
	}
}