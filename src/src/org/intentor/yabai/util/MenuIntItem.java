/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.intentor.yabai.util;

import lejos.nxt.Button;

/**
 * Displays an int value (as string) and allows increment/decrement of the value.
 */
public class MenuIntItem extends MenuItem {
	/** Item value. */
	private int value;
	/** Minimum value. */
	private final int minValue;
	/** Maximum value. */
	private final int maxValue;
	/** Step to increment/decrement. */
	private final int step;
	/** Original label. */
	private final String originalLabel;
	
	/**
	 * Creates a menu item.
	 * 
	 * @param label Item's label.
	 * @param value Item value.
	 * @param minValue Minimum value.
	 * @param maxValue Maximum value.
	 * @param step Step to increment/decrement..
	 */
	public MenuIntItem(String label, int value, int minValue, int maxValue, int step) {
		this.originalLabel = label;
		this.label = this.formatLabel(this.originalLabel, String.valueOf(value));
		this.value = value;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.step = step;
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
	 * @return Associated value.
	 */
	@Override
	public String getValue() {
		return String.valueOf(this.value);
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
			this.value += this.step;
			
			if (this.value > this.maxValue) {
				this.value = this.minValue;
			}
			
			this.label = this.formatLabel(this.originalLabel, String.valueOf(this.value));
		} else if (buttonId == Button.ID_ESCAPE) {
			//Decrease.
			this.value -= this.step;
			
			if (this.value < this.minValue) {
				this.value = this.maxValue;
			}
			
			this.label = this.formatLabel(this.originalLabel, String.valueOf(this.value));
		}
		
		return false;
	}
}