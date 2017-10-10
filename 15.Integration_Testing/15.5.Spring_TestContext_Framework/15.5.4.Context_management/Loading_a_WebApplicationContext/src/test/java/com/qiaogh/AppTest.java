package com.qiaogh;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.qiaogh.controller.IndexController;

/**
 * Unit test for simple App.
 */
@RunWith( SpringRunner.class )
@WebAppConfiguration
@ContextConfiguration( "/applicationContext.xml" )
public class AppTest {

    @Autowired
    private WebApplicationContext wac;
    
    @Autowired
    private IndexController indexController;
    
    private MockMvc mockMvc;
    
    @Before
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup( indexController ).build();
        Assert.assertNotNull( mockMvc );
    }
    
    @Test
    public void test() throws Exception {
        
    }
}
