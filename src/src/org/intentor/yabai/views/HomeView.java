package org.intentor.yabai.views;

import javax.microedition.lcdui.Graphics;
import lejos.nxt.LCD;
import lejos.util.TextMenu;
import org.intentor.yabai.Main;
import org.intentor.yabai.constants.UiImages;

/**
 * Home view.
 */
public class HomeView extends View {
	/** The view menu items. */
	private final String[] menuItems = { " Start", " Settings", " Exit" };
	
	/**
	 * Creates a new instance of the class.
	 */
	public HomeView() {
		super(null);
	}
	
	/** 
	 * Displays the view.
	 */
	@Override
	public void Show() {		
		TextMenu menu = new TextMenu(this.menuItems, 4);
		
		for(;;) {
			LCD.clear();
			
			this.graphics.drawRegion(UiImages.LOGO_INTENTOR, 0, 0, 
				UiImages.LOGO_INTENTOR.getWidth(), UiImages.LOGO_INTENTOR.getHeight(),
				0, 0, 0, Graphics.LEFT | Graphics.TOP);
			
			LCD.drawString("v" + Main.VERSION, 
				LCD.DISPLAY_CHAR_WIDTH - Main.VERSION.length() - 1, LCD.DISPLAY_CHAR_DEPTH - 1);
			int selection = menu.select();
			
			switch (selection) {
				case 0:
					
				break;
				case 1:
					this.Show(new SettingsView(this));
					return;
				case 2:
					return;
			}			
		}
	}
}
