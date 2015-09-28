package org.intentor.yabai.views;

import org.intentor.yabai.constants.UiImages;

/**
 * Speed configurations view.
 */
public class SpeedView extends OptionsView {
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param previousView The previous view. Can be null if there's no previous view.
	 */
	public SpeedView(View previousView) {
		super(previousView, "Speed", UiImages.ICON_SPEED,
			new String[] { " Front", " Back", " Rotate" });
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