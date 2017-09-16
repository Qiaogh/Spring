package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.qiaogh.aspect.PersonServiceAspect;
import com.qiaogh.aspect.SystemArchitecture;
import com.qiaogh.aspect.impl.PersonServiceAspectImpl;
import com.qiaogh.domain.Person;
import com.qiaogh.service.PersonService;
import com.qiaogh.service.impl.PersonServiceImpl;

public class AppTest {

    @Test
    public void testBasicApi() {
        PersonService personService = new PersonServiceImpl();
        Person qiaogh = personService.get( "1" );
        assertIsQiaogh( qiaogh );
    }
    
    @Test
    public void testAspectGet() {
        Assert.assertTrue( PersonServiceAspect.INVOKED_ADVICES.isEmpty() );
        
        AspectJProxyFactory factory = new AspectJProxyFactory( new PersonServiceImpl() );
        factory.addAspect( SystemArchitecture.class );
        factory.addAspect( PersonServiceAspectImpl.class );
        
        PersonService personService = factory.getProxy();
        Assert.assertNotNull( personService );
        
        Person qiaogh = personService.get( "1" );
        assertIsQiaogh( qiaogh );
        
        Assert.assertFalse( PersonServiceAspect.INVOKED_ADVICES.isEmpty() );
        Assert.assertEquals( 1, PersonServiceAspect.INVOKED_ADVICES.size() );
        Assert.assertTrue( PersonServiceAspect.INVOKED_ADVICES.containsKey( PersonServiceAspect.BEFORE_GET ) );
    }
    
    private void assertIsQiaogh( Person qiaogh ) {
        Assert.assertNotNull( qiaogh );
        Assert.assertEquals( "1", qiaogh.getId() );
        Assert.assertEquals( "Qiaogh", qiaogh.getName() );
        Assert.assertEquals( Integer.valueOf( 26 ), qiaogh.getAge() );
    }
}
