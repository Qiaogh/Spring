package com.qiaogh.convert;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import com.qiaogh.util.Constants;

public class StringToDateConverterFactory implements ConverterFactory<String, Date> {

    @Override
    public <T extends Date> Converter<String, T> getConverter( Class<T> targetType ) {
        return new DateConverter<T>( targetType );
    }

    private final class DateConverter<T extends Date> implements Converter<String, T> {

        private final Class<T> targetType;
        
        DateConverter( Class<T> targetType ) {
            this.targetType = targetType;
        }
        
        @SuppressWarnings( "unchecked" )
        @Override
        public T convert( String source ) {
            if ( Timestamp.class.isAssignableFrom( targetType ) ) {
                try {
                    return (T) Constants.DATE_TIME_FORMAT.parse( source );
                } catch ( ParseException e ) {
                    return null;
                }
            } else if ( Date.class.isAssignableFrom( targetType ) ) {
                try {
                    return (T) Constants.DATE_FORMAT.parse( source );
                } catch ( ParseException e ) {
                    return null;
                }
            }
            return null;
        }
    } 
}
