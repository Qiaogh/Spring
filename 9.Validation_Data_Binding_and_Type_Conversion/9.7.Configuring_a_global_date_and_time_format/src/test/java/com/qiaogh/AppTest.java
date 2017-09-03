package com.qiaogh;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.Person;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ConfigurableApplicationContext cxt;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }

    @Test
    public void test() throws ParseException {
        Person qiaogh = cxt.getBean( Person.class );
        Assert.assertNotNull( qiaogh );
        Assert.assertEquals( "Qiaogh", qiaogh.getName() );
        Assert.assertEquals( DateFormat.getDateInstance().parse( "1988-10-07" ), qiaogh.getBirthday() );
        Assert.assertEquals( Float.valueOf( 0.01f ), qiaogh.getAchievement() );
        Assert.assertEquals( BigDecimal.valueOf( 8888 ), qiaogh.getMoney() );
    }

    @After
    public void after() {
        cxt.close();
    }
}
