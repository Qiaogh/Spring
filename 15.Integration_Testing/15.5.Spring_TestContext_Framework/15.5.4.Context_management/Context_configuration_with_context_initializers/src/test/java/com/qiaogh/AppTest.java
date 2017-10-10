package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiaogh.config.TestAppCtxInitializer;

/**
 * Unit test for simple App.
 */
@RunWith( SpringRunner.class )
@ContextConfiguration( initializers = TestAppCtxInitializer.class )
public class AppTest {
    
    @Test
    public void test() {
        Assert.assertTrue( TestAppCtxInitializer.INVOKED );
    }
}
