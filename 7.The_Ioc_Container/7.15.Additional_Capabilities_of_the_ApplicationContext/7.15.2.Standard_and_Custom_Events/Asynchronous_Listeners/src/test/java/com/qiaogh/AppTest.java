package com.qiaogh;

import java.beans.Introspector;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

import com.qiaogh.config.AppConfig;
import com.qiaogh.domain.User;
import com.qiaogh.event.UserSavedEvent;
import com.qiaogh.service.UserService;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ConfigurableApplicationContext cxt;

    @Test
    public void testStandardEvents() {
        cxt = new AnnotationConfigApplicationContext( AppConfig.class );
        cxt.start();
        cxt.stop();
        cxt.close();
        new Thread( new Runnable() {
            @Override
            public void run() {
                Assert.assertTrue( AppConfig.contains( Introspector.decapitalize( ContextRefreshedEvent.class.getSimpleName() ) ) );
                Assert.assertTrue( AppConfig.contains( Introspector.decapitalize( ContextStartedEvent.class.getSimpleName() ) ) );
                Assert.assertTrue( AppConfig.contains( Introspector.decapitalize( ContextStoppedEvent.class.getSimpleName() ) ) );
                Assert.assertTrue( AppConfig.contains( Introspector.decapitalize( ContextClosedEvent.class.getSimpleName() ) ) );
            }
        } );
    }

    @Test
    public void testCustomEvents() {
        cxt = new AnnotationConfigApplicationContext( AppConfig.class );
        UserService userService = cxt.getBean( UserService.class );
        userService.save( new User( "1", "Qiaogh", "男" ) );
        new Thread( new Runnable() {
            @Override
            public void run() {
                Assert.assertTrue( AppConfig.contains( Introspector.decapitalize( UserSavedEvent.class.getSimpleName() ) ) );
            }
        } );
        cxt.close();
    }

    @Test
    public void testCustomEventConditions() {
        cxt = new AnnotationConfigApplicationContext( AppConfig.class );
        UserService userService = cxt.getBean( UserService.class );
        userService.save( new User( "2", "Qiy", "女" ) );
        Assert.assertFalse( AppConfig.contains( Introspector.decapitalize( UserSavedEvent.class.getSimpleName() ) ) );
        cxt.close();
    }
}
