package com.lbg.n2w.converters.language.values;

import com.lbg.n2w.converters.language.values.IValues;

public class EnglishValues implements IValues {

	@Override
	public String[] getTens() {
		// TODO Auto-generated method stub
		return new String[] { "", "ten", "twenty", "thrity", "forty", "fifty",
				"sixty", "seventy", "eighty", "ninety", "hundred" };
	}

	@Override
	public String[] getTillTeens() {
		// TODO Auto-generated method stub
		return new String[] { "", "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine", "ten", "eleven", "twelve",
				"thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
				"eighteen", "nineteen" };
	}

	@Override
	public String[] getPowerValues() {
		// TODO Auto-generated method stub
		return new String[] { "hundred", "thousand", "million" };

	}

}
