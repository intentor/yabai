package org.intentor.yabai.controllers;

import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import org.intentor.yabai.behaviours.*;
import org.intentor.yabai.core.IBotController;
import org.intentor.yabai.util.DataConverter;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Controls the bot.
 */
public class RearTouchSumoController implements IBotController {
	/** AI parameters. */
	protected final AiParameters parameters;
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param parameters AI parameters.
	 */
	public RearTouchSumoController(AiParameters parameters) {
		this.parameters = parameters;
	}
	
	/**
	 * Starts the bot program.
	 */
	@Override
	public void start() {
		Behavior searching = new Searching(
			DataConverter.motorPortFromChar(this.parameters.motorLeft),
			DataConverter.motorPortFromChar(this.parameters.motorRight),
			this.parameters.speedRotation);
		
		Behavior driveForward = new DriveForward(
			DataConverter.motorPortFromChar(this.parameters.motorLeft),
			DataConverter.motorPortFromChar(this.parameters.motorRight),
			this.parameters.speedForward,
			DataConverter.sensorPortFromInt(this.parameters.sensorUltrasonic),
			this.parameters.detectionDistance);
		
		Behavior driveBackward = new DriveBackward(
			DataConverter.motorPortFromChar(this.parameters.motorLeft),
			DataConverter.motorPortFromChar(this.parameters.motorRight),
			this.parameters.speedBackward,
			DataConverter.sensorPortFromInt(this.parameters.sensorTouch));	
		
		Behavior stopProgram = new StopProgram(
			DataConverter.motorPortFromChar(this.parameters.motorLeft),
			DataConverter.motorPortFromChar(this.parameters.motorRight));		
		
		Behavior[] behaviours = { searching, driveForward, driveBackward, stopProgram };
		
		Arbitrator arbitrator = new Arbitrator(behaviours);
		arbitrator.start();
	}
}
