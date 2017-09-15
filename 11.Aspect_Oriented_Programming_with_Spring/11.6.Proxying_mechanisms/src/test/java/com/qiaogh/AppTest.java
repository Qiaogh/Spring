package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

import com.qiaogh.advice.PersonServiceAdvice;
import com.qiaogh.domain.Person;
import com.qiaogh.service.PersonService;
import com.qiaogh.service.impl.PersonServiceImpl;

public class AppTest {

    @Test
    public void test() {
        ProxyFactory factory = new ProxyFactory( new Class<?>[]{ PersonService.class } );
        factory.setProxyTargetClass( true );
        factory.setTarget( new PersonServiceImpl() );
        factory.addAdvice( new PersonServiceAdvice() );
        
        PersonService personService = (PersonService) factory.getProxy();
        Assert.assertNotNull( personService );
        Person person = personService.get( "1" );
        Assert.assertNotNull( person );
        Assert.assertTrue( PersonServiceAdvice.INVOKED );
    }
}
