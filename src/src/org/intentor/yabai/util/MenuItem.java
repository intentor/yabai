package org.intentor.yabai.util;

import lejos.nxt.Button;

/**
 * Text menu item.
 */
public class MenuItem {
	/** Label prefix. */
	protected static final String PREFIX = " ";
	
	/** Item's label. */
	protected String label;
	
	/**
	 * Creates a menu item.
	 */
	public MenuItem() {
		this.label = "";
	}
	
	/**
	 * Creates a menu item.
	 * 
	 * @param label Item's label.
	 */
	public MenuItem(String label) {
		this.label = this.formatLabel(label, "");
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
	
	/**
	 * Formats text for the label, considering 15 characters wide.
	 * 
	 * @param left Left label value.
	 * @param right Right label value.
	 * @return The formatted label.
	 */
	protected final String formatLabel(String left, String right) {
		return PREFIX + left + " " + right;
	}
}
