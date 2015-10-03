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
	/** Current value index. */
	private int currentIndex;
	/** Original label. */
	private String originalLabel;
	
	/**
	 * Creates a menu item.
	 * 
	 * @param label Item's label.
	 * @param value Currently selected value.
	 * @param list Item's list.
	 */
	public MenuListItem(String label, String value, String[] list) {
		this.originalLabel = label;
		this.label = this.formatLabel(this.originalLabel, value);
		this.value = value;
		this.list = list;
		this.currentIndex = ArrayUtils.indexOf(this.list, this.value);
	}
	
	/**
	 * Gets the label value. It's 15 characters wide.
	 * 
	 * @return Label value.
	 */
	@Override
	public String getLabel() {
		return this.label;
	}
	
	/**
	 * Gets the additional value associated with the item.
	 * 
	 * @return Associated value.
	 */
	@Override
	public String getValue() {
		return this.value;
	}
	
	/**
	 * A button was pressed on the item.
	 * 
	 * @param buttonId Pressed button ID.
	 * @return Boolean value indicating whether the selected index should be returned.
	 */
	@Override
	public Boolean buttonPressed(int buttonId) {
		if (buttonId == Button.ID_ENTER) {
			//Increase.
			this.currentIndex++;
			
			if (this.currentIndex > (this.list.length - 1)) {
				this.currentIndex = 0;
			}
			
			this.value = this.list[this.currentIndex];			
			this.label = this.formatLabel(this.originalLabel, this.value);
		} else if (buttonId == Button.ID_ESCAPE) {
			//Decrease.
			this.currentIndex--;
			
			if (this.currentIndex < 0) {
				this.currentIndex = (this.list.length - 1);
			}
			
			this.value = this.list[this.currentIndex];			
			this.label = this.formatLabel(this.originalLabel, this.value);
		}
		
		return false;
	}
}
