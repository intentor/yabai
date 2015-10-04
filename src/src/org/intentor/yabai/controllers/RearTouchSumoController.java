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
		Behavior searching = new Searching(this.parameters);
		Behavior driveForward = new DriveForward(this.parameters);
		Behavior driveBackward = new DriveBackward(this.parameters);
		Behavior avoidBoundary = new AvoidBoundary(this.parameters);	
		Behavior stopProgram = new StopProgram(this.parameters);
		
		Behavior[] behaviours = { searching, driveForward, driveBackward, avoidBoundary, stopProgram };
		
		Arbitrator arbitrator = new Arbitrator(behaviours);
		arbitrator.start();
	}
}