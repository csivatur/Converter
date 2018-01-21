package com.lbg.n2w.converters.factory;

import java.util.Locale;

import com.lbg.n2w.converters.language.values.EnglishValues;
import com.lbg.n2w.converters.language.values.IValues;
/**
 * @author 9303105
 * Factory class to create the Values language specific Object
 *
 */
public final class ValuesFactory {

	private ValuesFactory() {
	}

	public static IValues getValues(final Locale _locale) {
		IValues values = null;
		if ("en".equals(_locale.getLanguage())) {
			values = new EnglishValues();
		}
		return values;
	}
}