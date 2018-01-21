package com.lbg.n2w.converters;

import com.lbg.n2w.converters.language.values.IConverter;

import static com.lbg.n2w.converters.Util.formatInteger;



public abstract class AbstractConvertor implements IConverter {

	/**
     * Converts Positive Integers to Words
     *
     * @see IConverter#convert(int)
     * @param value   value to convert
     * @return words representing the number     * 
     */
	@Override
	public String convert(int value) throws IllegalArgumentException{		
		StringBuffer str = new StringBuffer();
		final String numberAsString = formatInteger(value);
		final int millionValue = Integer.parseInt(numberAsString
				.substring(0, 3));
		final int thousandValue = Integer.parseInt(numberAsString.substring(3,
				6));
		final int hundredValue = Integer.parseInt(numberAsString
				.substring(6, 7));
		final int tensUnitsValue = Integer.parseInt(numberAsString.substring(7,
				9));
		str.append(convertWords(millionValue, 2))
				.append(convertWords(thousandValue, 1))
				.append(convertHundreds(hundredValue, 0))
				.append(appendDelimiter(hundredValue))
				.append(convertTensUnits(tensUnitsValue));
		return str.toString();
	}

	private String convertHundreds(final int hundreds, final int power) {
		if (hundreds > 0) {
			return getTeenWords()[hundreds] + " " + getPowerWords()[power];
		}
		return "";
	}

	private String convertWords(final int value, final int power) {
		if (value > 0) {
			return this.convert(value) + " " + getPowerWords()[power]+" ";
		}
		return "";
	}

	/**
     * Returns String Array till nineteen. Implementation is available in the 
     * Language specific implementation
     *
   
     * @return Returns String Array of words     * 
     */
	protected abstract String[] getTeenWords();
	
	/**
     * Returns Multiples of 10 till 100. Implementation is available in the 
     * Language specific implementation
     *
   
     * @return Returns String Array of words     * 
     */
	protected abstract String[] getTensWords();
	
	/**
     * Returns String Array of power numbers. Implementation is available in the 
     * Language specific implementation
     *
   
     * @return Returns String Array of words     * 
     */
	protected abstract String[] getPowerWords();
	
	/**
     * Converts two digit values to words. Implementation is available in the 
     * Language specific implementation
     *
   
     * @return Returns String Array of words     * 
     */
	protected abstract String convertTensUnits(final int _number);
	
	/**
     * Appends "and" delimiter. Implementation is available in the 
     * Language specific implementation
     *
   
     * @return Returns String Array of words     * 
     */
	protected abstract String appendDelimiter(final int _number);
	

}
