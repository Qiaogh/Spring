package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.aop.PersonServiceThrowsAdvice;
import com.qiaogh.domain.Person;
import com.qiaogh.exceptions.CannotFindPersonException;
import com.qiaogh.service.PersonService;
import com.qiaogh.service.impl.PersonServiceImpl;
import com.qiaogh.util.ResponseMessage;


/**
 * Unit test for simple App.
 */
public class AppTest implements ResponseMessage {
    
    private ConfigurableApplicationContext cxt;
    
    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }
    
    @Test
    public void testBasicApi() {
        PersonService personService = new PersonServiceImpl();
        Person qiaogh = personService.get( "1" );
        Assert.assertNotNull( qiaogh );
        Assert.assertEquals( "1", qiaogh.getId() );
        Assert.assertEquals( "Qiaogh", qiaogh.getName() );
        Assert.assertEquals( Integer.valueOf( 26 ), qiaogh.getAge() );
    }
    
    @Test
    public void testThrowingIllegalArgumentException() {
        String exName = IllegalArgumentException.class.getName();
        IllegalArgumentException exception = getThrowingSpecificExcpetionById( exName, null );
        Assert.assertNotNull( exception );
        Assert.assertTrue( exception instanceof IllegalArgumentException );
        Assert.assertEquals( String.format( ID_CANNOT_BE_NULL, "用户" ), exception.getMessage() );
    }
    
    @Test
    public void testThrowingCannotFindPersonException() {
        String id = "4";
        String exName = CannotFindPersonException.class.getName();
        CannotFindPersonException exception = getThrowingSpecificExcpetionById( exName, id );
        Assert.assertNotNull( exception );
        Assert.assertTrue( exception instanceof CannotFindPersonException );
        Assert.assertEquals( id, exception.getId() );
        Assert.assertEquals( String.format( CANNOT_FIND_PERSON, id ), exception.getMessage() );
    }
    
    @SuppressWarnings( "unchecked" )
    private <T> T getThrowingSpecificExcpetionById( String exName, String id ) {
        Assert.assertFalse( PersonServiceThrowsAdvice.THROWED_EXCPTIONS.containsKey( exName ) );
        PersonService personService = cxt.getBean( PersonService.SERVICEKEY, PersonService.class );
        
        try {
            personService.get( id );
        } catch ( Exception e ) {
            Assert.assertTrue( PersonServiceThrowsAdvice.THROWED_EXCPTIONS.containsKey( exName ) );
            return (T) PersonServiceThrowsAdvice.THROWED_EXCPTIONS.get( exName );
        }
        return null;
    }
    
    @After
    public void after() {
        cxt.close();
    }
}
