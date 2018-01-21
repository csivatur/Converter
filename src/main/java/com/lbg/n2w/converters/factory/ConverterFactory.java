package com.lbg.n2w.converters.factory;

import java.util.Locale;

import com.lbg.n2w.converters.language.EnglishImpl;
import com.lbg.n2w.converters.language.values.IConverter;
import com.lbg.n2w.converters.language.values.IValues;

/**
 * @author 9303105
 * Factory class to create the Converter language specific Object
 *
 */
public final class ConverterFactory {

	private ConverterFactory() {
	}

	public static IConverter getConverter(final Locale _locale,
			IValues values) {
		IConverter converter = null;
		if ("en".equals(_locale.getLanguage())) {
			converter = new EnglishImpl(values);
		}
		return converter;
	}
}