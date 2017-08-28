package com.qiaogh.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final DateFormat DATE_FORMAT = new SimpleDateFormat( "yyyy-MM-dd" );
    
    public static Date parseDate( String source ) throws ParseException {
        return DATE_FORMAT.parse( source );
    }
}
