package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.qiaogh.config.AppConfig;
import com.qiaogh.domain.Account;

@RunWith( SpringRunner.class )
@ContextConfiguration( classes = AppConfig.class )
@WebAppConfiguration
public class AppSessionTest {

    @Autowired
    private ApplicationContext cxt;
    
    @Autowired
    private MockHttpSession session;
    
    @Test
    public void test() {
        String ip = "192.168.3.1";
        session.setAttribute( "ip", ip );
        
        Account account = cxt.getBean( Account.class );
        Assert.assertNotNull( account );
        
        Assert.assertEquals( ip, account.getIp() );
    }
}
