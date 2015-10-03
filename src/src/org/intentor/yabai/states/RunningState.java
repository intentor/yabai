package org.intentor.yabai.states;

import javax.microedition.lcdui.Graphics;
import lejos.nxt.Battery;
import lejos.nxt.LCD;
import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.core.State;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Runs the behaviours.
 */
public class RunningState extends State {
	/** AI parameters. */
	protected AiParameters parameters;
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param parameters AI parameters.
	 */
	public RunningState(AiParameters parameters) {
		this.parameters = parameters;
	}
	
	@Override
	public void onStart() {
		
	}
	
	@Override
	public void update() {
		LCD.clear();
		
		this.graphics.drawRegion(Asset.ICON_BATTERY, 0, 0,  
			Asset.ICON_BATTERY.getWidth(), Asset.ICON_BATTERY.getHeight(),
			0, 0, 0, Graphics.LEFT | Graphics.TOP);		
		this.graphics.fillRect(2, 1, (int)Math.floor(10 * (Battery.getVoltage() / 9.0f)), 6);		
		
		this.graphics.drawRegion(Asset.LOGO_IAB, 0, 0,  
			Asset.LOGO_IAB.getWidth(), Asset.LOGO_IAB.getHeight(),
			0, LCD.SCREEN_WIDTH - Asset.LOGO_IAB.getWidth(), 0, Graphics.LEFT | Graphics.TOP);		
		
		LCD.drawString("Starting... 5", 0, 3);
		LCD.drawString("Press to stop", 0, LCD.DISPLAY_CHAR_DEPTH - 1);
	}
}
