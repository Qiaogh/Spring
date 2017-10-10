package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.request.ServletWebRequest;

@RunWith( SpringRunner.class )
@ContextConfiguration
@WebAppConfiguration
public class InjectingMocksTest {

    @Configuration
    static class Config {
        
    }

    @Autowired
    private ApplicationContext cxt;

    @Autowired
    private MockServletContext msc;

    @Autowired
    private MockHttpSession session;

    @Autowired
    private MockHttpServletRequest request;

    @Autowired
    private MockHttpServletResponse response;

    @Autowired
    private ServletWebRequest webRequest;

    @Test
    public void test() {
        Assert.assertNotNull( cxt );
        Assert.assertNotNull( msc );
        Assert.assertNotNull( session );
        Assert.assertNotNull( request );
        Assert.assertNotNull( response );
        Assert.assertNotNull( webRequest );
    }
}
