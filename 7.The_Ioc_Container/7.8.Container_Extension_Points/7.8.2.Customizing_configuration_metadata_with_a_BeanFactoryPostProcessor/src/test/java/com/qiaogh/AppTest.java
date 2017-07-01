package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.AnnotationedPerson;
import com.qiaogh.domain.JavaConfigPerson;
import com.qiaogh.domain.Person;
import com.qiaogh.util.StatusConstant;

/**
 * Unit test for simple App.
 */
public class AppTest implements StatusConstant {

    private ClassPathXmlApplicationContext cxt;
    private Person person;
    private AnnotationedPerson annotationedPerson;
    private JavaConfigPerson javaConfigPerson;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        person = cxt.getBean( Person.class );
        annotationedPerson = cxt.getBean( AnnotationedPerson.class );
        javaConfigPerson = cxt.getBean( JavaConfigPerson.class );
    }

    @Test
    public void test() {
        Assert.assertEquals( AFTER_PROPERTIES_SET, person.getStatus() );
        Assert.assertEquals( AFTER_PROPERTIES_SET, annotationedPerson.getStatus() );
    }

    @After
    public void after() {
        cxt.destroy();
        Assert.assertEquals( DESTROY, person.getStatus() );
        Assert.assertEquals( DESTROY, annotationedPerson.getStatus() );
        Assert.assertEquals( CLOSE, javaConfigPerson.getStatus() );
    }
}
