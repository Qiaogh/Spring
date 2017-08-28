package com.qiaogh;

import java.text.ParseException;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.converter.Converter;

import com.qiaogh.util.Constants;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ConfigurableApplicationContext cxt;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }

    @SuppressWarnings( "unchecked" )
    @Test
    public void testDateConverter() throws ParseException {
        String dateStr = "2017-08-27";
        Converter<String, Date> dateConverter = (Converter<String, Date>) cxt.getBean( "dateConverter" );
        Assert.assertNotNull( dateConverter );
        Assert.assertEquals( Constants.DATE_FORMAT.parse( dateStr ), dateConverter.convert( dateStr ) );
    }
    
    @SuppressWarnings( "unchecked" )
    @Test
    public void testDateTimeConverter() throws ParseException {
        String dateTimeStr = "2017-08-27 11:22:33";
        Converter<String, Date> dateConverter = (Converter<String, Date>) cxt.getBean( "dateTimeConverter" );
        Assert.assertNotNull( dateConverter );
        Assert.assertEquals( Constants.DATE_TIME_FORMAT.parse( dateTimeStr ), dateConverter.convert( dateTimeStr ) );
    }

    @After
    public void after() {
        cxt.close();
    }
}
