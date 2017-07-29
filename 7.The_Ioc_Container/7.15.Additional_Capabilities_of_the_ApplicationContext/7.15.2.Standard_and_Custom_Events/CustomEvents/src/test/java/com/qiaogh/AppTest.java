package com.qiaogh;

import java.beans.Introspector;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qiaogh.config.AppConfig;
import com.qiaogh.event.UserSavedEvent;
import com.qiaogh.service.UserService;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ConfigurableApplicationContext cxt;

    @Before
    public void before() {
        cxt = new AnnotationConfigApplicationContext( AppConfig.class );
    }
    
    @Test
    public void test() {
        UserService userService = cxt.getBean( UserService.class );
        userService.save();
        String eventName = Introspector.decapitalize( UserSavedEvent.class.getSimpleName() );
        Assert.assertTrue( AppConfig.contains( eventName ) );
        ApplicationEvent event = AppConfig.get( eventName );
        Assert.assertSame( userService, event.getSource() );
    }
    
    @After
    public void after() {
        cxt.close();
    }
}
