package org.intentor.yabai.views;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.util.TextMenu;

/**
 * Option view.
 */
public class OptionsView extends View {
	/** View title. */
	private final String title;
	/** View icon. Should be 16x16 pixels. */
	private final Image icon;
	/** The view menu items. */
	private final String[] menuItems;
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param previousView The previous view. Can be null if there's no previous view.
	 * @param title View title.
	 * @param icon View icon. Should be 16x16 pixels.
	 * @param menuItems The view menu items.
	 */
	public OptionsView(View previousView, String title, Image icon, String[] menuItems) {
		super(previousView);
		
		this.title = title;
		this.icon = icon;
		this.menuItems = menuItems;
	}
	
	/** 
	 * Displays the view.
	 */
	@Override
	public void Show() {
		TextMenu menu = new TextMenu(this.menuItems, 3);
		
		while (!Button.ESCAPE.isDown()) {
			LCD.clear();
			
			this.graphics.drawRegion(this.icon, 0, 0,  
				this.icon.getWidth(), this.icon.getHeight(),
				0, 0, 0, Graphics.LEFT | Graphics.TOP);
			
			LCD.drawString(this.title, LCD.DISPLAY_CHAR_WIDTH - this.title.length(), 0);
			
			this.graphics.drawLine(LCD.CELL_WIDTH * 3 + 2, LCD.CELL_HEIGHT + 2, 
				LCD.CELL_WIDTH * LCD.DISPLAY_CHAR_WIDTH, LCD.CELL_HEIGHT + 2);
			
			int selection = menu.select();
			if (selection >= 0 && this.MenuItemSelected(selection)) {
				return;
			}
		}
		
		this.ReturnToPreviousView();
	}
	
	/**
	 * Called when the view is being hidden.
	 */
	@Override
	public void OnHide() {
		
	}
	
	/**
	 * Called when a menu item is selected.
	 * 
	 * @param option The selected option.
	 * @return Boolean value indicating whether the menu item caused a new view to be opened.
	 */
	protected Boolean MenuItemSelected(int option) {
		return false;
	}
}
