package org.intentor.yabai.states;

import javax.microedition.lcdui.Graphics;
import lejos.nxt.LCD;
import org.intentor.yabai.constants.StateName;
import org.intentor.yabai.constants.Asset;
import org.intentor.yabai.core.State;
import org.intentor.yabai.util.Menu;
import org.intentor.yabai.util.MenuItem;

/**
 * Home state.
 */
public class HomeState extends State {
	/** The view menu items. */
	private final MenuItem[] menuItems = { 
		new MenuItem("Start"),
		new MenuItem("Settings"),
		new MenuItem("Exit")
	};
	
	/** Program version. */
	private final String version;
	/** The text menu. */
	private Menu menu;
	
	public HomeState(String version) {
		this.version = "v" + version;
	}
	
	@Override
	public void onStart() {
		if (this.menu == null) {
			this.menu = new Menu(this.menuItems, 4);
		}
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
				this.stateManager.start(StateName.RUNNING);
			break;
			case 1:
				this.stateManager.start(StateName.SETTINGS);
			break;
			case 2:
				System.exit(0);
			break;
		}
	}
}
