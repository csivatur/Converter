package com.lbg.n2w.converters;

import java.util.Locale;

import com.lbg.n2w.converters.factory.ConverterFactory;
import com.lbg.n2w.converters.factory.ValuesFactory;
import com.lbg.n2w.converters.language.values.IConverter;
import com.lbg.n2w.converters.language.values.IValues;

public class MainConverter {
	/**
     * Main method which calls the convert API
     *   
     */
	public static void main(String[] args) {
		try{
		IValues values = ValuesFactory.getValues(Locale.ENGLISH);
		IConverter converter = ConverterFactory.getConverter(Locale.ENGLISH, values);
		System.out.println(converter.convert(999999999));
		}catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}

	}

}
