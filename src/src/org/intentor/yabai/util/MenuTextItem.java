package org.intentor.yabai.util;

import lejos.nxt.Button;

/**
 * Text menu item.
 */
public class MenuTextItem {
	/** Item's label. */
	protected String label;
	
	/**
	 * Creates a menu item.
	 * 
	 * @param label Item's label.
	 */
	public MenuTextItem(String label) {
		this.label = label;
	}
	
	/**
	 * Gets the label value. It's 15 characters wide.
	 * 
	 * @return The label value.
	 */
	public String getLabel() {
		return this.label;
	}
	
	/**
	 * Gets the additional value associated with the item.
	 * 
	 * @return The associated value.
	 */
	public String getValue() {
		return "";
	}
	
	/**
	 * A button was pressed on the item.
	 * 
	 * @param button Pressed button.
	 * @return Boolean value indicating whether the selected index should be returned.
	 */
	public Boolean buttonPressed(Button button) {
		return (button == Button.ENTER);
	}
}
