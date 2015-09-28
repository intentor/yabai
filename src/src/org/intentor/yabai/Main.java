package org.intentor.yabai;

import org.intentor.yabai.views.HomeView;

/**
 * Example leJOS Project with an ant build file
 *
 */
public class Main {
	/** Program version. */
	public static final String VERSION = "0.1";
	
	public static void main(String[] args) {
		HomeView view = new HomeView();
		view.Show();
		
		
		
		//Running
		/*
		g.drawRegion(UiImages.ICON_BATTERY, 0, 0,  
			UiImages.ICON_BATTERY.getWidth(), UiImages.ICON_BATTERY.getHeight(),
			0, 0, 0, Graphics.LEFT | Graphics.TOP);		
		g.fillRect(2, 1, (int)Math.floor(10 * (Battery.getVoltage() / 9.0f)), 6);		
		
		g.drawRegion(UiImages.ICON_IAB, 0, 0,  
			UiImages.ICON_IAB.getWidth(), UiImages.ICON_IAB.getHeight(),
			0, LCD.SCREEN_WIDTH - UiImages.ICON_IAB.getWidth(), 0, Graphics.LEFT | Graphics.TOP);		
		
		LCD.drawString("Starting... 5", 0, 3);
		LCD.drawString("Press to stop", 0, LCD.DISPLAY_CHAR_DEPTH - 1);
		*/
	}
}
