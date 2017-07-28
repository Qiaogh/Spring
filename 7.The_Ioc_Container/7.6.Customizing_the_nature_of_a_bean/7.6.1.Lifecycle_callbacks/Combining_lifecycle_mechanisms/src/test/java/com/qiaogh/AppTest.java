package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.Person;
import com.qiaogh.util.StatusConstant;

/**
 * Unit test for simple App.
 */
public class AppTest implements StatusConstant {

    private static final Integer INDEX_1 = 1;
    private static final Integer INDEX_2 = 2;
    private static final Integer INDEX_3 = 3;
    
    private ConfigurableApplicationContext cxt;
    private Person person;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        person = cxt.getBean( Person.class );
    }

    @Test
    public void test() {
        Assert.assertEquals( POST_CONSTRUCT, person.getAnnotatedStatus() );
        Assert.assertEquals( AFTER_PROPERTIES_SET, person.getInterfacedStatus() );
        Assert.assertEquals( INIT, person.getXmlBesedStatus() );
        Assert.assertEquals( INDEX_1, person.getStartSeq().get( POST_CONSTRUCT ) );
        Assert.assertEquals( INDEX_2, person.getStartSeq().get( AFTER_PROPERTIES_SET ) );
        Assert.assertEquals( INDEX_3, person.getStartSeq().get( INIT ) );
    }

    @After
    public void after() {
        if ( cxt instanceof ConfigurableApplicationContext ) {
            ( (AbstractApplicationContext) cxt ).destroy();
        }
        Assert.assertEquals( PRE_DESTROY, person.getAnnotatedStatus() );
        Assert.assertEquals( DESTROY, person.getInterfacedStatus() );
        Assert.assertEquals( FREE, person.getXmlBesedStatus() );
        Assert.assertEquals( INDEX_1, person.getStopSeq().get( PRE_DESTROY ) );
        Assert.assertEquals( INDEX_2, person.getStopSeq().get( DESTROY ) );
        Assert.assertEquals( INDEX_3, person.getStopSeq().get( FREE ) );
    }
}
