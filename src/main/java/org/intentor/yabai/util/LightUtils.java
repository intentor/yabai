package org.intentor.yabai.util;

/**
 * Light utilities.
 */
public final class LightUtils {
	/**
	 * Checks whether a boundary is detected.
	 * 
	 * @param lightValue Light value.
	 * @param color Color to detect (B/W).
	 * @param blackLevel Maximum light value to detect black.
	 * @param whiteLevel Minimum light value to detect white.
	 * @return Boolean value indicating whether the boundary has been detected.
	 */
	public static Boolean checkColor(int lightValue, char color, int blackLevel, int whiteLevel) {		
		if (color == 'B') {
			return (lightValue <= blackLevel);
		} else {
			return (lightValue >= whiteLevel);
		}
	}
}