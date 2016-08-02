package org.intentor.yabai.controllers;

import org.intentor.yabai.behaviors.StopProgram;
import org.intentor.yabai.behaviors.DriveBackward;
import org.intentor.yabai.behaviors.AvoidBoundary;
import org.intentor.yabai.behaviors.Searching;
import org.intentor.yabai.behaviors.DriveForward;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import org.intentor.yabai.core.IBotController;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Controls a bot with a rear touch sensor.
 * 
 * It uses a differential movememnt with 2 servo motors.
 * 
 * Main sensors for this bot:
 * 1. Ultrasonic sensor for seeking.
 * 2. Light sensor for avoiding ring's boundaries.
 * 3. Touch sensor to detect rear contact.
 */
public class RearTouchSumoController implements IBotController {
	/** AI parameters. */
	protected final AiParameters parameters;
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param parameters AI parameters.
	 * @param startDirection Direction to start the movement.
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