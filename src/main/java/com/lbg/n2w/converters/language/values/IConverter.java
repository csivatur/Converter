package com.lbg.n2w.converters.language.values;
/**
 * Interface should be implemented by Language specific implementation
 * 
 */
public interface IConverter {
	/**
     * Converts Positive Integers to Words
     *
     * @see IConverter#convert(int)
     * @param value   value to convert
     * @return words representing the number     * 
     */
	String convert(final int value) throws IllegalArgumentException;
}
