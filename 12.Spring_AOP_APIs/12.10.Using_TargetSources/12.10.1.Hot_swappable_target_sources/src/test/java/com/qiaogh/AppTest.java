package com.qiaogh;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.target.HotSwappableTargetSource;

import com.qiaogh.domain.Person;
import com.qiaogh.service.PersonService;
import com.qiaogh.service.impl.PersonServiceImpl;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private HotSwappableTargetSource targetSource;
    private PersonService proxy;
    
    @Before
    public void before() {
        targetSource = new HotSwappableTargetSource( new PersonServiceImpl() );
        ProxyFactory factory = new ProxyFactory( PersonService.class, targetSource );
        proxy = (PersonService) factory.getProxy();
    }
    
    @Test
    public void testOriginalTarget() {
        Person qiaogh = proxy.get( "1" );
        Assert.assertNotNull( qiaogh );
        Assert.assertEquals( "1", qiaogh.getId() );
        Assert.assertEquals( "Qiaogh", qiaogh.getName() );
        Assert.assertEquals( Integer.valueOf( 26 ), qiaogh.getAge() );
    }
    
    @Test
    public void testSwapedTarget() {
        targetSource.swap( new PersonServiceImpl() );
        testOriginalTarget();
    }
}
