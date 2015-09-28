package org.intentor.yabai.views;

import javax.microedition.lcdui.Graphics;

/**
 * Base view.
 */
public abstract class View {
	/** The previous view. */
	protected View previousView;
	/** Graphics object. */
	protected Graphics graphics = new Graphics();
	
	/**
	 * Creates a new instance of the class.
	 * 
	 * @param previousView The previous view. Can be null if there's no previous view.
	 */
	public View(View previousView) {
		this.previousView = previousView;
	}
	
	/**
	 * Displays the view.
	 */
	public abstract void Show();
	
	/**
	 * Displays a given view.
	 * 
	 * @param view The view to be displayed.
	 */
	public void Show(View view) {
		this.OnHide();	
		
		if (view != null) {
			view.Show();
		}
	}
	
	/**
	 * Called when the view is being hidden.
	 */
	protected void OnHide() {
		
	}
	
	/**
	 * Returns to the previous view.
	 */
	public void ReturnToPreviousView() {
		this.Show(this.previousView);
	}
}
