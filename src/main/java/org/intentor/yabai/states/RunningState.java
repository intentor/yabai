package org.intentor.yabai.states;

import javax.microedition.lcdui.Graphics;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Sound;
import lejos.util.Timer;
import lejos.util.TimerListener;
import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.controllers.RearTouchSumoController;
import org.intentor.yabai.core.IBotController;
import org.intentor.yabai.core.State;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Runs the behaviours that executes the AI.
 */
public class RunningState extends State implements TimerListener {
	/** Timeout to wait for button press (milliseconds). */
	protected static final int BUTTON_POLL_INTERVAL = 10;
	
	/** AI parameters. */
	protected AiParameters parameters;
	/** Startup timer. */
	protected Timer timer;
	/** Timer counter. */
	protected int counter;
	/** The message to display. */
	protected String message = "";
	
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
		this.timer = new Timer(1000, this);
		this.counter = this.parameters.timer;
		this.message = "Starting... " + String.valueOf(this.counter);

		this.timedOut();
		this.timer.start();
	}
	
	@Override
	public void update() {
		LCD.clear();		
		
		this.graphics.drawRegion(Asset.LOGO_IAB, 0, 0,
			Asset.LOGO_IAB.getWidth(), Asset.LOGO_IAB.getHeight(),
			0, LCD.SCREEN_WIDTH - Asset.LOGO_IAB.getWidth(), 0, Graphics.LEFT | Graphics.TOP);
		
		if (this.message != null) {
		    LCD.drawString(this.message, 0, 3);
        }
		LCD.drawString("Press to stop", 0, LCD.DISPLAY_CHAR_DEPTH - 1);
		
		int button = Button.waitForAnyPress(BUTTON_POLL_INTERVAL);		
		if (button != 0) {
			this.timer.stop();
			this.stateManager.start(StateName.HOME);
		}
	}

	@Override
	public void timedOut() {
		this.counter--;
		Sound.playTone(500 + (this.parameters.timer - this.counter) * 50, (this.counter == 0 ? 500 : 100));
		
		if (this.counter == 0) {
			this.timer.stop();
			this.message = null;
			IBotController controller = new RearTouchSumoController(this.parameters);
			controller.start();
		} else {
			this.message = "Starting... " + String.valueOf((this.counter + 1));
		}
	}
}