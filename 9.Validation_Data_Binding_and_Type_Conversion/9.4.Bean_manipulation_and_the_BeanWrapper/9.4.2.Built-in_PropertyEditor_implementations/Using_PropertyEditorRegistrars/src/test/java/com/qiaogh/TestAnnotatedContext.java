package com.qiaogh;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.util.Locale;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;

import com.qiaogh.config.AppConfig;
import com.qiaogh.domain.Person;
import com.qiaogh.util.DateUtil;
import com.qiaogh.util.Sex;

/**
 * Unit test for simple App.
 */
public class TestAnnotatedContext {

    private ConfigurableApplicationContext cxt;

    @Before
    public void before() {
        cxt = new AnnotationConfigApplicationContext( AppConfig.class );
    }

    @Test
    public void test() throws ParseException {
        String profileStr = "11111111";
        String birthdayStr = "1988-10-07";
        String ageStr = "26";
        String moneyStr = "200,200.00";
        String blogStr = "http://www.baidu.com";
        String highStr = "0200";
        String fontStr = "楷体";
        String sonStr = "Qiao--";
        
        Person qiaogh = cxt.getBean( Person.class );
        
        Assert.assertNotNull( qiaogh.getProfile() );
        Assert.assertNotNull( qiaogh.getPersonClass() );
        Assert.assertNotNull( qiaogh.getBirthday() );
        Assert.assertNotNull( qiaogh.getAge() );
        Assert.assertNotNull( qiaogh.getCountry() );
        Assert.assertNotNull( qiaogh.getContacts() );
        Assert.assertNotNull( qiaogh.getMoney() );
        Assert.assertNotNull( qiaogh.getBlog() );
        Assert.assertNotNull( qiaogh.getHigh() );
        Assert.assertNotNull( qiaogh.getColor() );
        Assert.assertNotNull( qiaogh.getSex() );
        Assert.assertNotNull( qiaogh.getFont() );
        Assert.assertNotNull( qiaogh.getSon() );
        Assert.assertEquals( profileStr.length(), qiaogh.getProfile().length );
        Assert.assertEquals( Person.class, qiaogh.getClass() );
        Assert.assertEquals( false, qiaogh.isLocked() );
        Assert.assertEquals( DateUtil.parseDate( birthdayStr ), qiaogh.getBirthday() );
        Assert.assertEquals( Integer.valueOf( ageStr ), qiaogh.getAge() );
        Assert.assertEquals( Locale.CHINA, qiaogh.getCountry() );
        Assert.assertEquals( 2, qiaogh.getContacts().keySet().size() );
        Assert.assertEquals( "police", qiaogh.getContacts().get( "name" ) );
        Assert.assertEquals( "110", qiaogh.getContacts().get( "tel" ) );
        Assert.assertEquals( StringUtils.deleteAny( moneyStr, "," ), qiaogh.getMoney() );
        Assert.assertEquals( blogStr, qiaogh.getBlog().toString() );
        Assert.assertEquals( Short.decode( highStr ), qiaogh.getHigh() );
        Assert.assertEquals( Color.YELLOW, qiaogh.getColor() );
        Assert.assertEquals( Sex.MALE, qiaogh.getSex() );
        Assert.assertEquals( Font.decode( fontStr ), qiaogh.getFont() );
        Assert.assertEquals( sonStr, qiaogh.getSon().getName() );
    }

    @After
    public void after() {
        cxt.close();
    }
}
