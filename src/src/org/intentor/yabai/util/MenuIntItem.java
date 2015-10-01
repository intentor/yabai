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
	/** The value. */
	private int value;
	/** The minimum value. */
	private int minValue;
	/** The maximum value. */
	private int maxValue;
	/** The step to increment/decrement. */
	private int step;
	/** The original label. */
	private String originalLabel;
	
	/**
	 * Creates a menu item.
	 * 
	 * @param label Item's label.
	 * @param value The value.
	 * @param minValue The minimum value.
	 * @param maxValue The maximum value.
	 * @param step The step to increment/decrement..
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
	 * @return The associated value.
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
