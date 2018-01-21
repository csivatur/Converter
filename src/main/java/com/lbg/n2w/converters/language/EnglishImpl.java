package com.lbg.n2w.converters.language;

import com.lbg.n2w.converters.AbstractConvertor;
import com.lbg.n2w.converters.language.values.IValues;

import static com.lbg.n2w.converters.Util.validate;

public class EnglishImpl extends AbstractConvertor {

	IValues englishValues;

	public EnglishImpl(IValues englishValues) {
		this.englishValues = englishValues;
	}
	
	@Override
	public String convert(int value) throws IllegalArgumentException {
		validate(value);
		return super.convert(value);
	}

	@Override
	protected String convertTensUnits(final int value) {
		final StringBuilder ret = new StringBuilder();
		if (value < 20) {
			ret.append(this.getTeenWords()[value]);
		} else {
			ret.append(this.getTensWords()[value / 10]).append('-')
					.append(this.getTeenWords()[value % 10]);
		}
		return ret.toString();
	}
	
	@Override
	protected String appendDelimiter(final int hundreds) {
		// TODO Auto-generated method stub
		if(hundreds>1){
			return " and ";
		}
		return "";
	}
	

	@Override
	protected String[] getTeenWords() {
		// TODO Auto-generated method stub
		return englishValues.getTillTeens();
	}

	@Override
	protected String[] getTensWords() {
		// TODO Auto-generated method stub
		return englishValues.getTens();
	}

	@Override
	protected String[] getPowerWords() {
		// TODO Auto-generated method stub
		return englishValues.getPowerValues();
	}

}
