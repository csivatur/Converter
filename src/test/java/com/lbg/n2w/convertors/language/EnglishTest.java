package com.lbg.n2w.convertors.language;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import org.junit.Assume;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.lbg.n2w.converters.factory.ConverterFactory;
import com.lbg.n2w.converters.factory.ValuesFactory;
import com.lbg.n2w.converters.language.values.IConverter;
import com.lbg.n2w.converters.language.values.IValues;


/**
 * Implements the test cases for English conversion of numbers to words.
 *
 * @author The eFaps Team
 * @version $Id$
 */
@RunWith(Parameterized.class)
public class EnglishTest
{
	private Type type;
	private int value;
    private String words;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    public EnglishTest(Type type,int value, String words) {
    	this.type=type;
        this.value = value;
        this.words = words;
    }
    
    @Test
    public void testNegativeCases() {
    	Assume.assumeTrue(type == Type.FAILURE);
      exception.expect(IllegalArgumentException.class);
      exception.expectMessage(words);
      IValues values = ValuesFactory.getValues(Locale.ENGLISH);
      IConverter converter = ConverterFactory.getConverter(Locale.ENGLISH, values);
      converter.convert(value);
    }
    
    
    @Test
    public void testPostiveValues() {
    	Assume.assumeTrue(type == Type.SUCCESS);
        IValues values = ValuesFactory.getValues(Locale.ENGLISH);
        IConverter converter = ConverterFactory.getConverter(Locale.ENGLISH, values);
        assertEquals("Result", words, converter.convert(value));
    }
    
    /**
     * Returns the English test data as an array of an array of integer and the
     * related converted text.
     *
     * @return English test data
     */
    enum Type {FAILURE, SUCCESS};
    @Parameters
    public static Collection<Object[]> testData()
    {
        Object[][] data= new Object[][] {
        	{Type.FAILURE,-1, "Value provided should be a non-zero positive digit till 999999999"},
        	{Type.FAILURE,0, "Value provided should be a non-zero positive digit till 999999999"},
        	{Type.FAILURE,1000000000, "Value provided should be a non-zero positive digit till 999999999"},
        	{Type.SUCCESS,1, "one"},
            {Type.SUCCESS,2, "two"},
            {Type.SUCCESS,33, "thrity-three"},
            {Type.SUCCESS,455, "four hundred and fifty-five"},
            {Type.SUCCESS,6999, "six thousand nine hundred and ninety-nine"},
            {Type.SUCCESS,73456, "seventy-three thousand four hundred and fifty-six"},
            {Type.SUCCESS,889922, "eight hundred and eighty-nine thousand nine hundred and twenty-two"},
            {Type.SUCCESS,9912366, "nine million nine hundred and twelve thousand three hundred and sixty-six"},
            {Type.SUCCESS,88992117, "eighty-eight million nine hundred and ninety-two thousand one hundredseventeen"},
            {Type.SUCCESS,21, "twenty-one"},
            {Type.SUCCESS,71, "seventy-one"},
            {Type.SUCCESS,999999999, "nine hundred and ninety-nine million nine hundred and ninety-nine thousand nine hundred and ninety-nine"},
        };
        return Arrays.asList(data);
    }
}

