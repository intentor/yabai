package org.intentor.yabai.util;

import lejos.nxt.Button;

/**
 * Text menu item.
 */
public class MenuItem {
	/** Label prefix. */
	protected static final String PREFIX = " ";
	/** Label display width. */
	protected static final int LABEL_WIDTH = 15;
	
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
	 * @return Label value.
	 */
	public String getLabel() {
		return this.label;
	}
	
	/**
	 * Gets the additional value associated with the item.
	 * 
	 * @return Associated value.
	 */
	public String getValue() {
		return "";
	}
	
	/**
	 * A button was pressed on the item.
	 * 
	 * @param buttonId Pressed button ID.
	 * @return Boolean value indicating whether the selected index should be returned.
	 */
	public Boolean buttonPressed(int buttonId) {
		return (buttonId == Button.ID_ENTER);
	}
	
	/**
	 * Formats text for the label, considering 15 characters wide.
	 * 
	 * @param left Left label value.
	 * @param right Right label value.
	 * @return The formatted label.
	 */
	protected final String formatLabel(String left, String right) {
		if (right.equals("")) {
			return PREFIX + left;
		} else {
			StringBuilder builder = new StringBuilder();
			builder.append(PREFIX);
			builder.append(left);
			
			int spaces = LABEL_WIDTH - builder.length() - right.length();
			for (int index = 0; index < spaces; index++) {
				builder.append(" ");
			}
			
			builder.append(right);
			
			return builder.toString();
		}
	}
}