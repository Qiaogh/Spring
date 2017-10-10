package com.qiaogh;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiaogh.config.AppConfig;
import com.qiaogh.domain.Person;
import com.qiaogh.listener.SimpleTestExecutionListener;

/**
 * Unit test for simple App.
 */
@RunWith( SpringRunner.class )
@TestExecutionListeners( SimpleTestExecutionListener.class )
@ContextConfiguration( classes = AppConfig.class )
public class RegisterCustomTestExecutionListenerTest {
    
    @Autowired
    private Person qiaogh;
    
    @BeforeClass
    public static void beforeClass() {
        assertEqualsLastElement( SimpleTestExecutionListener.BEFORE_TEST_CLASS );
    }
    
    @Before
    public void before() {
        assertEqualsLastElement( SimpleTestExecutionListener.BEFORE_TEST_METHOD );
    }
    
    @Test
    public void test() {
        assertEqualsLastElement( SimpleTestExecutionListener.BEFORE_TEST_METHOD );
        Assert.assertNull( qiaogh );
    }
    
    @After
    public void after() {
        assertEqualsLastElement( SimpleTestExecutionListener.BEFORE_TEST_METHOD );
    }
    
    @AfterClass
    public static void afterClass() {
        assertEqualsLastElement( SimpleTestExecutionListener.AFTER_TEST_METHOD );
    }
    
    public static void assertEqualsLastElement( String value ) {
        List<String> invoked = SimpleTestExecutionListener.INVOKED;
        Assert.assertEquals( value, invoked.get( invoked.size() - 1 ) );
    }
}
