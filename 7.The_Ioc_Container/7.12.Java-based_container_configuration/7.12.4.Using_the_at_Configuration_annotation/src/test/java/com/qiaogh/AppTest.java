package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qiaogh.domain.Teacher;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ConfigurableApplicationContext cxt;

    @Before
    public void before() {
        cxt = new AnnotationConfigApplicationContext( School.class );
    }

    @Test
    public void test() {
        com.qiaogh.domain.Class clazz = cxt.getBean( com.qiaogh.domain.Class.class );
        Assert.assertNotNull( clazz );
        Assert.assertNotEquals( clazz.play(), clazz.play() );
    }

    @Test
    public void testTeacher() {
        com.qiaogh.domain.Class clazz = cxt.getBean( com.qiaogh.domain.Class.class );
        Assert.assertNotNull( clazz );
        Teacher teacher = clazz.getTeacher();
        Assert.assertEquals( teacher, clazz.getTeacher() );
    }

    @After
    public void after() {
        cxt.close();
    }
}
