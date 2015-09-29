package org.intentor.yabai.states;

import org.intentor.yabai.core.State;
import org.intentor.yabai.core.data.FileManager;
import org.intentor.yabai.valueobjects.AiParameters;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import lejos.nxt.LCD;
import lejos.util.TextMenu;

/**
 * Options base state.
 */
public abstract class OptionsState extends State {
	/** View title. */
	private final String title;
	/** View icon. Should be 16x16 pixels. */
	private final Image icon;
	/** The view menu items. */
	private final String[] menuItems;
	/** The view menu items. */
	private TextMenu menu;
	/** File manager. */
	protected FileManager file;
	/** AI parameters. */
	protected AiParameters parameters;
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param title View title.
	 * @param icon View icon. Should be 16x16 pixels.
	 * @param menuItems The view menu items.
	 * @param file File manager.
	 */
	public OptionsState(String title, Image icon, String[] menuItems, FileManager file) {		
		this.title = title;
		this.icon = icon;
		this.menuItems = menuItems;
		this.file = file;
		
		String data = this.file.read();
		this.parameters = AiParameters.createFromString(data);
	}
	
	@Override
	public void onStart() {
		if (this.menu == null) {
			this.menu = new TextMenu(this.menuItems, 3);
		}
	}
	
	/** 
	 * Updates/renders the state.
	 */
	@Override
	public void update() {		
		LCD.clear();

		this.graphics.drawRegion(this.icon, 0, 0,  
			this.icon.getWidth(), this.icon.getHeight(),
			0, 0, 0, Graphics.LEFT | Graphics.TOP);

		LCD.drawString(this.title, LCD.DISPLAY_CHAR_WIDTH - this.title.length(), 0);

		this.graphics.drawLine(LCD.CELL_WIDTH * 3 + 2, LCD.CELL_HEIGHT + 2, 
			LCD.CELL_WIDTH * LCD.DISPLAY_CHAR_WIDTH, LCD.CELL_HEIGHT + 2);
		
		this.onMenuOptionSelected(menu.select());
	}
	
	/**
	 * Called when a menu option is selected.
	 * 
	 * @param option The selected option.
	 */
	protected abstract void onMenuOptionSelected(int option);
}
