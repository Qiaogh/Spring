package com.qiaogh.java.text;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class DateFormatTest {

    @Test
    public void testFullStyle() throws ParseException {
        testSpecifiedStyle( "2017年9月3日 星期日", DateFormat.FULL );
    }

    @Test
    public void testLongStyle() throws ParseException {
        testSpecifiedStyle( "2017年9月3日", DateFormat.LONG );
    }
    
    @Test
    public void testMediumStyle() throws ParseException {
        testSpecifiedStyle( "2017-9-3", DateFormat.MEDIUM );
    }

    @Test
    public void testShortStyle() throws ParseException {
        testSpecifiedStyle( "17-9-3", DateFormat.SHORT );
    }
    
    private void testSpecifiedStyle( String dateStr, int style ) throws ParseException {
        DateFormat specifiedDateFormatter = DateFormat.getDateInstance( style );
        Date date = specifiedDateFormatter.parse( dateStr );
        Assert.assertNotNull( date );
        Assert.assertEquals( dateStr, specifiedDateFormatter.format( date ) );
    }
}
