package com.qiaogh.convert;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.qiaogh.util.Constants;

public final class StringToDate implements Converter<String, Date> {

    private static final DateFormat DATE_FORMAT = Constants.DATE_FORMAT;
    
    @Override
    public Date convert( String source ) {
        try {
            return DATE_FORMAT.parse( source );
        } catch ( ParseException e ) {
            return null;
        }
    }
}
