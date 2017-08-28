package com.qiaogh;

import java.text.ParseException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.convert.converter.Converter;

import com.qiaogh.convert.StringToDate;
import com.qiaogh.util.Constants;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test() throws ParseException {
        String dateStr = "2017-08-27";
        Converter<String, Date> converter = new StringToDate();
        Assert.assertEquals( Constants.DATE_FORMAT.parse( dateStr ), converter.convert( dateStr ) );
    }

}
