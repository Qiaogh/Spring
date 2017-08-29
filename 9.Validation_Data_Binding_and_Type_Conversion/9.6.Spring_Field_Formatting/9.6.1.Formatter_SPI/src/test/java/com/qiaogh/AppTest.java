package com.qiaogh;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.format.datetime.DateFormatter;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test() throws ParseException {
        String dateStr = "2017-08-29";
        DateFormatter formatter = new DateFormatter( "yyyy-MM-dd" );
        Date date = formatter.parse( dateStr, Locale.CHINESE );
        Assert.assertNotNull( date );
        Assert.assertEquals( dateStr, formatter.print( date, Locale.CHINESE ) );
    }
}
