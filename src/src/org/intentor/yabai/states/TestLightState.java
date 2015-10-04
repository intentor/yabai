package org.intentor.yabai.states;

import javax.microedition.lcdui.Graphics;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.core.State;
import org.intentor.yabai.util.DataConverter;
import org.intentor.yabai.util.LightUtils;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Tests the light sensor.
 */
public class TestLightState extends State {
	/** Timeout to wait for button press (milliseconds). */
	protected static final int BUTTON_POLL_INTERVAL = 10;
	
	/** AI parameters. */
	private final AiParameters parameters;
	/** Light sensor. */
	private LightSensor light;
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param parameters AI parameters.
	 */
	public TestLightState(AiParameters parameters) {
		this.parameters = parameters;
	}
	
	@Override
	public void onStart() {		
		SensorPort lightPort = DataConverter.sensorPortFromInt(this.parameters.sensorLight);		
		this.light = new LightSensor(lightPort);
		
		LCD.clear();
	}
	
	@Override
	public void update() {		
		this.graphics.drawRegion(Asset.LOGO_IAB, 0, 0,
			Asset.LOGO_IAB.getWidth(), Asset.LOGO_IAB.getHeight(),
			0, LCD.SCREEN_WIDTH - Asset.LOGO_IAB.getWidth(), 0, Graphics.LEFT | Graphics.TOP);
				
		int lightValue = this.light.readValue();		
		Boolean check = LightUtils.checkColor(
			lightValue, this.parameters.color, this.parameters.blackLevel, this.parameters.whiteLevel);
		
		LCD.clear(3);
		LCD.drawString("Light: " + String.valueOf(lightValue), 0, 3);
		LCD.clear(4);
		LCD.drawString("Match: " + String.valueOf(check), 0, 4);
		
		LCD.drawString("Press to back", 0, LCD.DISPLAY_CHAR_DEPTH - 1);
		
		int button = Button.waitForAnyPress(BUTTON_POLL_INTERVAL);		
		if (button != 0) {
			this.stateManager.start(StateName.SETTINGS_LIGHT);
		}
	}
}