package org.intentor.yabai.behaviors;

import lejos.nxt.*;
import lejos.robotics.subsumption.Behavior;
import org.intentor.yabai.util.DataConverter;
import org.intentor.yabai.valueobjects.AiParameters;

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
	 * @param parameters AI parameters to configure the behaviour.
	 */
	public StopProgram(AiParameters parameters) {
		MotorPort motorLeftPort = DataConverter.motorPortFromChar(parameters.motorLeft);
		MotorPort motorRightPort = DataConverter.motorPortFromChar(parameters.motorRight);
		
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