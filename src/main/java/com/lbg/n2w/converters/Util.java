package com.lbg.n2w.converters;

/**
 * @author 9303105
 *
 */
public class Util {

	/**
     * Formats the input integer to 9 character String
     *   
     * @return Returns String     * 
     */
	public static String formatInteger(final int value) {
		return String.format("%09d", value);
	}

	/**
     * Validates the input integer. Throws Exception if the values is less than 1 and greater than 999999999
     *      
     */
	public static void validate(final int value) {
		if (value <= 0 || value > 999999999) {
			throw new IllegalArgumentException(
					"Value provided should be a non-zero positive digit till 999999999");
		}
	}
}
