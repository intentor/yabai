/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.intentor.yabai.util;

import java.util.ArrayList;
import java.util.List;

/**
 * String utility methods.
 */
public final class StringUtils {
	/**
	 * Splits a String according to a delimitator.
	 * 
	 * @param input Input string.
	 * @param delimitator Split delimitator.
	 * @return A list continaing the splitted value.
	 */
	public static List<String> split(String input, String delimitator) {
		List<String> l = new ArrayList<String>();
		int offset = 0;

		while (true) {
			int index = input.indexOf(delimitator, offset);
			
			if (index == -1) {
				l.add(input.substring(offset));
				return l;
			} else {
				l.add(input.substring(offset, index));
				offset = (index + delimitator.length());
			}
		}
	}
	
	/**
	 * Converts a String into an Array of bytes.
	 * 
	 * @param text Value to convert.
	 * @return An Array of bytes.
	 */ 
    public static byte[] getBytes(String text) {
        byte[] bytes = new byte[text.length() + 1];
        
        for(int i = 0; i < text.length(); i++) {
            bytes[i] = (byte)text.charAt(i);
        }
		
        bytes[text.length()] = 0;
 
        return bytes;
    }
}
