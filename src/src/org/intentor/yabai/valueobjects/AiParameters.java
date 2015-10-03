package org.intentor.yabai.valueobjects;

import org.intentor.yabai.constants.BoundaryColor;
import org.intentor.yabai.util.StringUtils;
import java.util.List;

/**
 * AI parameters.
 */
public class AiParameters {
	/** String separator. */
	private static final String SEPARATOR = ";";
	
	/** Left motor port. */
	public char motorLeft;
	/** Right motor port. */
	public char motorRight;
	/** Light sensor port. */
	public int sensorLight;
	/** Ultrasonic sensor port. */
	public int sensorUltrasonic;
	/** Touch sensor port. */
	public int sensorTouch;
	/** Timer to start the AI (seconds). */
	public int timer;
	/** Boundary color. */
	public String color;
	/** Detection distance. */
	public int detectionDistance;
	/** Forward speed (degrees). */
	public int speedForward;
	/** Backward speed (degrees). */
	public int speedBackward;
	/** Rotation speed (degrees). */
	public int speedRotation;
	
	/**
	 * Serializes the current instance as string.
	 * 
	 * @return The object as string.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(this.motorLeft);
		builder.append(SEPARATOR);
		builder.append(this.motorRight);
		builder.append(SEPARATOR);
		builder.append(this.sensorLight);
		builder.append(SEPARATOR);
		builder.append(this.sensorUltrasonic);
		builder.append(SEPARATOR);
		builder.append(this.sensorTouch);
		builder.append(SEPARATOR);
		builder.append(this.timer);
		builder.append(SEPARATOR);
		builder.append(this.color);
		builder.append(SEPARATOR);
		builder.append(this.detectionDistance);
		builder.append(SEPARATOR);
		builder.append(this.speedForward);
		builder.append(SEPARATOR);
		builder.append(this.speedBackward);
		builder.append(SEPARATOR);
		builder.append(this.speedRotation);
		
		return builder.toString();
	}
	
	/**
	 * Creates the default parameters.
	 * 
	 * @return The default parameters.
	 */
	public static AiParameters createDefault() {
		AiParameters parameters = new AiParameters();
		
		parameters.motorLeft = 'A';
		parameters.motorRight = 'B';
		parameters.sensorLight = 1;
		parameters.sensorUltrasonic = 2;
		parameters.sensorTouch = 3;
		parameters.timer = 5;
		parameters.color = BoundaryColor.WHITE;
		parameters.detectionDistance = 30;
		parameters.speedForward = 1440;
		parameters.speedBackward = 1440;
		parameters.speedRotation = 1080;
		
		return parameters;
	}
	
	/**
	 * Creates the parameters from a serialized string.
	 * 
	 * @param value Serialized string.
	 * @return The AiParameters object.
	 */
	public static AiParameters createFromString(String value) {
		AiParameters parameters = new AiParameters();
		
		List<String> values = StringUtils.split(value, SEPARATOR);
		
		parameters.motorLeft = values.get(0).charAt(0);
		parameters.motorRight = values.get(1).charAt(0);
		parameters.sensorLight = Integer.parseInt(values.get(2));
		parameters.sensorUltrasonic = Integer.parseInt(values.get(3));
		parameters.sensorTouch = Integer.parseInt(values.get(4));
		parameters.timer = Integer.parseInt(values.get(5));
		parameters.color = values.get(6);
		parameters.detectionDistance = Integer.parseInt(values.get(7));
		parameters.speedForward = Integer.parseInt(values.get(8));
		parameters.speedBackward = Integer.parseInt(values.get(9));
		parameters.speedRotation = Integer.parseInt(values.get(10));
		
		return parameters;
	}
}
