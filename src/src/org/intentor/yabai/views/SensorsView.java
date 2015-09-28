package org.intentor.yabai.views;

import org.intentor.yabai.constants.UiImages;

/**
 * Sensors ports view.
 */
public class SensorsView extends OptionsView {
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param previousView The previous view. Can be null if there's no previous view.
	 */
	public SensorsView(View previousView) {
		super(previousView, "Sensors", UiImages.ICON_SENSORS,
			new String[] { " Light", " Sonar", " Touch" });
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
				return false;				
			case 1:
				return false;			
			case 2:
				return false;			
			case 3:
				return false;
			default:
				return false;
		}
	}
}