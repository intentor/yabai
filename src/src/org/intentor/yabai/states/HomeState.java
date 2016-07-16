package org.intentor.yabai.states;

import javax.microedition.lcdui.Graphics;
import lejos.nxt.LCD;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.constants.RotationDirection;
import org.intentor.yabai.core.State;
import org.intentor.yabai.util.Menu;
import org.intentor.yabai.util.MenuItem;
import org.intentor.yabai.valueobjects.AiParameters;

/**
 * Home state.
 */
public class HomeState extends State {
	/** View menu items. */
	private final MenuItem[] menuItems = {
		new MenuItem("Start Left"),
		new MenuItem("Start Right"),
		new MenuItem("Settings"),
		new MenuItem("Exit")
	};
	
	/** Program version. */
	private final String version;
	/** AI parameters. */
	protected AiParameters parameters;
	/** Main menu. */
	private Menu menu;
	
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param version Program version.
	 * @param parameters AI parameters.
	 */
	public HomeState(String version, AiParameters parameters) {
		this.version = "v" + version;
		this.parameters = parameters;
	}
	
	@Override
	public void onStart() {
		if (this.menu == null) {
			this.menu = new Menu(this.menuItems, 4);
		}
		
		this.menu.setCurrentIndex(0);
	}
	
	@Override
	public void update() {	
		LCD.clear();

		this.graphics.drawRegion(Asset.LOGO_INTENTOR, 0, 0, 
			Asset.LOGO_INTENTOR.getWidth(), Asset.LOGO_INTENTOR.getHeight(),
			0, 0, 0, Graphics.LEFT | Graphics.TOP);

		LCD.drawString(this.version, 
			LCD.DISPLAY_CHAR_WIDTH - this.version.length(), LCD.DISPLAY_CHAR_DEPTH - 1);
		
		int selection = menu.select();
		switch (selection) {
			case 0:
				this.parameters.rotation = RotationDirection.LEFT;
				this.stateManager.start(StateName.RUNNING);
			break;
			case 1:
				this.parameters.rotation = RotationDirection.RIGHT;
				this.stateManager.start(StateName.RUNNING);
			break;
			case 2:
				this.stateManager.start(StateName.SETTINGS);
			break;
			case 3:
				System.exit(0);
			break;
		}
	}
}