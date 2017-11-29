package com.qiaogh;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.qiaogh.config.AppConfig;
import com.qiaogh.config.MvcConfig;


/**
 * Unit test for simple App.
 */
@RunWith( SpringRunner.class )
@WebAppConfiguration
@ContextHierarchy( value = {
    @ContextConfiguration( name = "root", classes = AppConfig.class ),
    @ContextConfiguration( name = "mvc", classes = MvcConfig.class )
})
public class AppTest {
    
    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;
    
    @Before
    public void before() {
        mvc = MockMvcBuilders.webAppContextSetup( context ).build();
    }
    
    @SuppressWarnings( "unchecked" )
    @Test
    public void test() throws Exception {
        MvcResult result = mvc.perform( MockMvcRequestBuilders.get( "/config/regular/spring-web-1.0.0.pom" ) )
                .andExpect( MockMvcResultMatchers.view().name( "config/regular" ) )
                .andExpect( MockMvcResultMatchers.model().attributeExists( "configs" ) )
                .andDo( MockMvcResultHandlers.print() )
                .andReturn();

        Map<String, Object> configs = (Map<String, Object>) result.getModelAndView().getModel().get( "configs" );
        Assert.assertNotNull( configs );
        Assert.assertEquals( "spring-web", configs.get( "name" ) );
        Assert.assertEquals( "1.0.0", configs.get( "version" ) );
        Assert.assertEquals( "pom", configs.get( "extension" ) );
    }
}
