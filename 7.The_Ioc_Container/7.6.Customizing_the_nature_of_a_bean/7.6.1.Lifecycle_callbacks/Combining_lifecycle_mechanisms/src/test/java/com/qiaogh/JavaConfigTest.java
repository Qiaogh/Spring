package com.qiaogh;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.JavaConfigPerson;
import com.qiaogh.util.StatusConstant;

public class JavaConfigTest implements StatusConstant {

    private ClassPathXmlApplicationContext cxt;
    private JavaConfigPerson javaConfigPerson;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        javaConfigPerson = cxt.getBean( JavaConfigPerson.class );
    }

    @Test
    public void test() {
        cxt.destroy();
        Assert.assertEquals( CLOSE, javaConfigPerson.getStatus() );
    }
}
