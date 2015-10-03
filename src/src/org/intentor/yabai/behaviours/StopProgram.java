package org.intentor.yabai.behaviours;

import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;

/**
 * Stops the program.
 */
public class StopProgram implements Behavior {
	/** Left motor. */
	private final NXTRegulatedMotor motorLeft;
	/** Right motor. */
	private final NXTRegulatedMotor motorRight;
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param motorLeftPort Motor left port.
	 * @param motorRightPort Motor right port.
	 */
	public StopProgram(MotorPort motorLeftPort, MotorPort motorRightPort) {
		this.motorLeft = Motor.getInstance(motorLeftPort.getId());
		this.motorRight = Motor.getInstance(motorRightPort.getId());
	}
	
	@Override
	public boolean takeControl() {
		int key = Button.readButtons();
		return (key != 0);
	}

	@Override
	public void suppress() {
		
	}

	@Override
	public void action() {
		this.motorLeft.stop();
		this.motorRight.stop();
		
		System.exit(0);
	}
}