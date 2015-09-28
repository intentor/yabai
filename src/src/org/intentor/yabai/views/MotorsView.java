package org.intentor.yabai.views;

import org.intentor.yabai.constants.UiImages;

/**
 * Motors ports view.
 */
public class MotorsView extends OptionsView {
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param previousView The previous view. Can be null if there's no previous view.
	 */
	public MotorsView(View previousView) {
		super(previousView, "Motors", UiImages.ICON_MOTORS,
			new String[] { " Left", " Right" });
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
