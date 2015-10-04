package org.intentor.yabai.states;

import javax.microedition.lcdui.Graphics;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.core.State;
import org.intentor.yabai.util.DataConverter;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Tests the ultrasonic sensor.
 */
public class TestUltrasonicState extends State {
	/** Timeout to wait for button press (milliseconds). */
	protected static final int BUTTON_POLL_INTERVAL = 10;
	
	/** AI parameters. */
	private final AiParameters parameters;
	/** Ultrasonic sensor. */
	private UltrasonicSensor sonar;
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param parameters AI parameters.
	 */
	public TestUltrasonicState(AiParameters parameters) {
		this.parameters = parameters;
	}
	
	@Override
	public void onStart() {
		SensorPort sonarPort = DataConverter.sensorPortFromInt(this.parameters.sensorUltrasonic);		
		this.sonar = new UltrasonicSensor(sonarPort);
		
		LCD.clear();
	}
	
	@Override
	public void update() {		
		this.graphics.drawRegion(Asset.LOGO_IAB, 0, 0,
			Asset.LOGO_IAB.getWidth(), Asset.LOGO_IAB.getHeight(),
			0, LCD.SCREEN_WIDTH - Asset.LOGO_IAB.getWidth(), 0, Graphics.LEFT | Graphics.TOP);
				
		int distance = this.sonar.getDistance();	
		Boolean check = (distance <= this.parameters.detectionDistance);
		
		LCD.clear(3);
		LCD.drawString("Distance: " + String.valueOf(distance), 0, 3);
		LCD.clear(4);
		LCD.drawString("Match: " + String.valueOf(check), 0, 4);
		
		LCD.drawString("Press to back", 0, LCD.DISPLAY_CHAR_DEPTH - 1);
		
		int button = Button.waitForAnyPress(BUTTON_POLL_INTERVAL);		
		if (button != 0) {
			this.stateManager.start(StateName.SETTINGS_ULTRASONIC);
		}
	}
}