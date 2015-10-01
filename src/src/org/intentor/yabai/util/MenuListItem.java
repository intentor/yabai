package org.intentor.yabai.util;

import lejos.nxt.Button;

/**
 * Displays a value from a text list and allows navigation through its values.
 */
public class MenuListItem extends MenuItem {
	/** Currently selected value. */
	private String value;
	/** Item's list. */
	private String[] list;
	
	/**
	 * Creates a menu item.
	 * 
	 * @param label Item's label.
	 * @param value Currently selected value.
	 * @param list Item's list.
	 */
	public MenuListItem(String label, String value, String[] list) {
		this.label = this.formatLabel(label, value);
		this.value = value;
		this.list = list;
	}
	
	/**
	 * Gets the label value. It's 15 characters wide.
	 * 
	 * @return The label value.
	 */
	@Override
	public String getLabel() {
		return this.label;
	}
	
	/**
	 * Gets the additional value associated with the item.
	 * 
	 * @return The associated value.
	 */
	@Override
	public String getValue() {
		return this.value;
	}
	
	/**
	 * A button was pressed on the item.
	 * 
	 * @param button Pressed button.
	 * @return Boolean value indicating whether the selected index should be returned.
	 */
	@Override
	public Boolean buttonPressed(Button button) {
		return (button == Button.ENTER);
	}
}
