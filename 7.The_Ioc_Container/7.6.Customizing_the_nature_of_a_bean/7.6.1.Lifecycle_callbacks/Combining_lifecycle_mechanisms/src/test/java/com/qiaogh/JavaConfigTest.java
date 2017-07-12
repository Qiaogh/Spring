package com.qiaogh;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.JavaConfigPerson;
import com.qiaogh.util.StatusConstant;

public class JavaConfigTest implements StatusConstant {

    private ApplicationContext cxt;
    private JavaConfigPerson javaConfigPerson;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        javaConfigPerson = cxt.getBean( JavaConfigPerson.class );
    }

    @Test
    public void test() {
        if ( cxt instanceof ConfigurableApplicationContext ) {
            ( (AbstractApplicationContext) cxt ).destroy();
        }
        Assert.assertEquals( CLOSE, javaConfigPerson.getStatus() );
    }
}
