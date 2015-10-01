package org.intentor.yabai.util;

import lejos.nxt.Button;
import lejos.nxt.LCD;

/**
 * Displays a list of items.  The select() method allows the user to scroll the list using the right and left keys to scroll forward and backward 
 * through the list. The location of the list , and an optional title can be specified.
 * @author Roger Glassey (2007). Updated by André "intentor" Martins (2015).
 */
public class Menu {
	/** Timout used for {@link Button#waitForAnyPress(int)} in {@link #select(int, int)}. */
	protected static final int BUTTON_POLL_INTERVAL = 10; // Time to wait for button press
	
	/** Location of the top row of the list; set by constructor, used by display(). */
	protected int _topRow = 0;	
	/** Number of rows displayed; set by constructor, used by display(). */
	protected int _height = 8;	
	/** Optional menu title displayed immediately above the list of items. */
	protected String _title;	
	/** Array of items to be displayed ;set by constructor, used by select(). */
	protected MenuTextItem[] _items;	
	/** Effective length of items array  - number of items before null.  */
	protected int _length;	
	/** Index of the list item at the top of the list; set by constructor, used by select(). */
	protected int _topIndex = 0;  	
	/** Identifies the currently selected item. */
	protected static final char SEL_CHAR = '>';	
	/** A blank line. */
	public static final String BLANK = "                ";	
	/** Boolean to cause select to quit. */
	protected boolean _quit = false;	
	/** Start time for select(). */
	protected int _startTime;
	/** The currently index. */
	protected int _currentIndex;
		
	/**
	 * This constructor sets location of the top row of the item list to row 0 of the display.
	 */
	public Menu(MenuTextItem[] items) {
		this(items, 0, null);
	}
	
	/**
	 * This constructor allows specification location of the item list .
	 */
	public Menu (MenuTextItem[] items, int topRow) {
		this(items, topRow, null);
	}
	
	/**
	 * This constuctor allows the specfication of a title (of up to 16 characters) and the location of the item list <br>
	 * The title is displayed in the row above the item list.
	 * 
	 * @param items  -  string array containing the menu items. No items beyond the first null will be displayed.
	 */	
	public Menu(MenuTextItem[] items, int topRow, String title) {
		if (topRow < 0 || (topRow == 0 && title != null))
			throw new IllegalArgumentException("illegal topRow argument");
		
		_topRow = topRow;
		setTitle(title);
		this.setItems(items);
	}
	
	/**
	 * Set menu title.
	 * 
	 * @param title  the new title
	 */
	public void setTitle(String title) {
		_title = title;
		if(_topRow <= 0)
			_topRow = 1;		
		_height = 8 - _topRow;
		if(_height > _length)
			_height = _length;
	}
	
	/**
	 * Gets list of items in this menu; 
	 * 
	 * @return the array of items.
	 */
	public MenuTextItem[] getItems() {
	   return _items;
	}
	
	/**
	 * Sets the array of items to be displayed.
	 * 
	 * @param items
	 */
	public void setItems(MenuTextItem[] items) {
		_items = items;
		
		if (items == null) {
			_length = 0;
		} else {
			int i = 0;
			while(i < items.length && items[i] != null) {
				i++;
			}
			_length = i;
		}
		_height = 8 - _topRow;
		if(_height > _length) {
			_height = _length;
		}
	}
	
	/**
	 * Returns Currently selected index.
	 * 
	 * @return The selected index.
	 */
	public int getSelectedIndex() {
	   return _currentIndex;
	}
	
	/**
	 * Allows the user to scroll through the items, using the right and left buttons (forward and back)  The Enter key closes the menu <br>
	 * and returns the index of the selected item. <br>
	 * The menu display wraps items that scroll off the top will reappear on the bottom and vice versa.
	 * 
	 * The selectedIndex is set to the first menu item.
	 * 
	 * @return the index of the selected item
	 **/
	public int select() { 
	   return select(0,0); 
	} 
	
	/**
	 * Version of select without timeout.
	 */
	public int select(int selectedIndex) {
		return select(selectedIndex, 0);
	}

	/**
	 * Allows the user to scroll through the items, using the right and left buttons (forward and back)  The Enter key closes the menu <br>
	 * and returns the index of the selected item. <br>
	 * The menu display wraps items that scroll off the top will reappear on the bottom and vice versa.
	 * 
	 * This version of select allows the selected index to be set when the menu is first displayed.
	 * 
	 * @param selectedIndex the index to start the menu on
	 * @return the index of the selected item
	 **/
	public int select(int selectedIndex, int timeout) { 
		_currentIndex = selectedIndex;
		
		if (_currentIndex >= _length) {
			//might result in -1
			_currentIndex = _length -1;
		} else if (_currentIndex < 0) {
			_currentIndex = 0;
		}
		
		_quit = false;
		resetTimeout();
		
		if (_topIndex > _currentIndex) {
			_topIndex = _currentIndex;
		}
		if (_topIndex > _length - _height) {
			_topIndex = _length - _height;
		}
		
		this.display(_currentIndex, _topIndex);
		
		while(true) {
			int button;
			do {				
				if (_quit)
					return -2; // quit by another thread
				
				if (timeout > 0 && System.currentTimeMillis() - _startTime >= timeout) 
					return -3; // timeout
				
				button = Button.waitForAnyPress(BUTTON_POLL_INTERVAL);
			} while (button == 0);
			
			if (button == Button.ID_ENTER && _currentIndex >= 0 && _currentIndex < _length) {
				return _currentIndex;
			}
			if (button == Button.ID_ESCAPE) {
				return -1; //Escape
			}
			if (button == Button.ID_RIGHT) {
				//Scroll forward
				
				_currentIndex++;
				// check for index out of bounds
				if(_currentIndex >= _length) {
					_currentIndex = 0;
					_topIndex = 0;
				}
				else if(_currentIndex >= _topIndex + _height) {
					_topIndex = _currentIndex - _height + 1;
				}
			}			
			if (button == Button.ID_LEFT) {
				//Scroll backward
				
				_currentIndex--;
				// check for index out of bounds
				if(_currentIndex < 0) {
					_currentIndex  = _length - 1;
					_topIndex = _length - _height;
				} else if(_currentIndex < _topIndex) {
					_topIndex = _currentIndex;
				}
			}
			
			this.display(_currentIndex, _topIndex);
		}
	}
	
	/**
	 * Method to call from another thread to quit the menu.
	 */
    public void quit()  {
    	_quit = true;
    }
	
	/**
	 * Reset the timeout period.
	 */
	public void resetTimeout() {
		_startTime = (int) System.currentTimeMillis();
	}
	
	/**
	 * Helper method used by select().
	 */
	protected void display(int currentIndex, int topIndex) {
		if(_title != null) {
			LCD.drawString(_title, 0, _topRow - 1);
		}
		
		int max = _topRow + _height;
		for (int i = _topRow; i < max; i++) {
			LCD.drawString(BLANK, 0, i);
			int idx = i - _topRow + topIndex;
			if (idx >= 0 && idx < _length) {
				LCD.drawChar(idx == currentIndex ? SEL_CHAR : ' ', 0, i);
				LCD.drawString(_items[idx].getLabel(), 1, i);
			}
		}
		LCD.asyncRefresh();
	}	
}

