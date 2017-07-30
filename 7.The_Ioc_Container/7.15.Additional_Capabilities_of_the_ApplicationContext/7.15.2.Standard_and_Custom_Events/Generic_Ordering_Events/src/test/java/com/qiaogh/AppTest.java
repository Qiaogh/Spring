package com.qiaogh;

import java.beans.Introspector;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qiaogh.config.AppConfig;
import com.qiaogh.domain.User;
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
    public void testSaveNull() {
        UserService userService = cxt.getBean( UserService.class );
        try {
            userService.save( null );
            throw new UnsupportedOperationException( "不支持此操作！" );
        } catch ( Exception e ) {
            Assert.assertTrue( e instanceof IllegalArgumentException );
            Assert.assertEquals( "用户信息不可为空！", e.getMessage() );
            Assert.assertFalse( AppConfig.contains( Introspector.decapitalize( UserSavedEvent.class.getSimpleName() ) ) );
        }
    }
    
    @Test
    public void testSaveNullId() {
        UserService userService = cxt.getBean( UserService.class );
        try {
            userService.save( new User() );
            throw new UnsupportedOperationException( "不支持此操作！" );
        } catch ( Exception e ) {
            Assert.assertTrue( e instanceof IllegalArgumentException );
            Assert.assertEquals( "用户编号不可为空！", e.getMessage() );
            Assert.assertFalse( AppConfig.contains( Introspector.decapitalize( UserSavedEvent.class.getSimpleName() ) ) );
        }
    }
    
    @Test
    public void testCustomEvents() {
        UserService userService = cxt.getBean( UserService.class );
        userService.save( new User( "1", "Qiaogh", "男" ) );
        Assert.assertTrue( AppConfig.contains( Introspector.decapitalize( UserSavedEvent.class.getSimpleName() ) ) );
    }
    
    @After
    public void after() {
        cxt.close();
        AppConfig.clear();
    }
}
