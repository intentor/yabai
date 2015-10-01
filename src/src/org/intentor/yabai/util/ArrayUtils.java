package org.intentor.yabai.util;

/**
 * Array utilities.
 */
public final class ArrayUtils {
	/**
	 * Gets the index from a given value in an array.
	 * 
	 * @param array The array.
	 * @param value The value to be evaluated.
	 * @return The index or -1.
	 */
	public static int indexOf(String[] array, String value) {
		int index = -1;
		
		for (int arrIndex = 0; arrIndex < array.length; arrIndex++) {
			if (array[arrIndex].equals(value)) {
				index = arrIndex;
				break;
			}
		}
		
		return index;
	}
}
