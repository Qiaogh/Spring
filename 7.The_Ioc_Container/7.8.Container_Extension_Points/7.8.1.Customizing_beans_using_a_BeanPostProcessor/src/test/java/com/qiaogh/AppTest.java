package com.qiaogh;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @SuppressWarnings( "resource" )
    @Test
    public void test() {
        new ClassPathXmlApplicationContext( "applicationContext.xml" ).destroy();;
    }

}
