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

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ConfigurableApplicationContext cxt;

    @Test
    public void test() {
        cxt = new AnnotationConfigApplicationContext( AppConfig.class );
        cxt.start();
        cxt.stop();
        cxt.close();
        Assert.assertTrue( AppConfig.contains( Introspector.decapitalize( ContextRefreshedEvent.class.getSimpleName() ) ) );
        Assert.assertTrue( AppConfig.contains( Introspector.decapitalize( ContextStartedEvent.class.getSimpleName() ) ) );
        Assert.assertTrue( AppConfig.contains( Introspector.decapitalize( ContextStoppedEvent.class.getSimpleName() ) ) );
        Assert.assertTrue( AppConfig.contains( Introspector.decapitalize( ContextClosedEvent.class.getSimpleName() ) ) );
    }
}
