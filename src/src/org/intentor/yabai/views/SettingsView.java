/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.intentor.yabai.views;

import org.intentor.yabai.constants.UiImages;

/**
 * Settings view.
 */
public class SettingsView extends OptionsView {
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param previousView The previous view. Can be null if there's no previous view.
	 */
	public SettingsView(View previousView) {
		super(previousView, "Settings", UiImages.ICON_SETTINGS,
			new String[] { " Motors", " Sensors", " Parameters", " Speed" });
	}
	
	/**
	 * Called when a menu item is selected.
	 * 
	 * @param option The selected option.
	 * @return Boolean value indicating whether the menu item caused a new view to be opened.
	 */
	@Override
	protected Boolean MenuItemSelected(int option) {
		switch (option) {
			case 0:
				this.Show(new MotorsView(this));
				return true;				
			case 1:
				this.Show(new SensorsView(this));
				return true;			
			case 2:
				this.Show(new ParametersView(this));
				return true;			
			case 3:
				this.Show(new SpeedView(this));
				return true;
			default:
				return false;
		}
	}
}