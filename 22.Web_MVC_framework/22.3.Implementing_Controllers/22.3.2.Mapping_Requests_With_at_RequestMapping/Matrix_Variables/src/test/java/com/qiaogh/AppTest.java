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
    
    @Test
    public void testMixture() throws Exception {
        MvcResult result = mvc.perform( MockMvcRequestBuilders.get( "/config/mixture/1;q=qiaogh" ) )
                .andExpect( MockMvcResultMatchers.view().name( "config/mixture" ) )
                .andExpect( MockMvcResultMatchers.model().attributeExists( "configs" ) )
                .andDo( MockMvcResultHandlers.print() )
                .andReturn();

        Map<String, Object> configs = getConfigs( result );
        Assert.assertNotNull( configs );
        Assert.assertEquals( "1", configs.get( "value" ) );
        Assert.assertEquals( "qiaogh", configs.get( "q" ) );
    }
    
    @Test
    public void testPathVar() throws Exception {
        MvcResult result = mvc.perform( MockMvcRequestBuilders.get( "/config/pathVar/q=1/q=2/q=3" ) )
                .andExpect( MockMvcResultMatchers.view().name( "config/pathVar" ) )
                .andExpect( MockMvcResultMatchers.model().attributeExists( "configs" ) )
                .andDo( MockMvcResultHandlers.print() )
                .andReturn();
        
        Map<String, Object> configs = getConfigs( result );
        Assert.assertNotNull( configs );
        Assert.assertEquals( "1", configs.get( "value1" ) );
        Assert.assertEquals( "2", configs.get( "value2" ) );
        Assert.assertEquals( "3", configs.get( "value3" ) );
    }
    
    @Test
    public void testDefault() throws Exception {
        MvcResult result = mvc.perform( MockMvcRequestBuilders.get( "/config/defaultValue/value=" ) )
                .andExpect( MockMvcResultMatchers.view().name( "config/defaultValue" ) )
                .andExpect( MockMvcResultMatchers.model().attributeExists( "configs" ) )
                .andDo( MockMvcResultHandlers.print() )
                .andReturn();
        
        Map<String, Object> configs = getConfigs( result );
        Assert.assertNotNull( configs );
        Assert.assertEquals( "default", configs.get( "value" ) );
    }
    
    @Test
    public void map() throws Exception {
        MvcResult result = mvc.perform( MockMvcRequestBuilders.get( "/config/map/value1=1;value2=2;value3=3" ) )
                .andExpect( MockMvcResultMatchers.view().name( "config/map" ) )
                .andExpect( MockMvcResultMatchers.model().attributeExists( "configs" ) )
                .andDo( MockMvcResultHandlers.print() )
                .andReturn();
        
        Map<String, Object> configs = getConfigs( result );
        Assert.assertNotNull( configs );
        Assert.assertEquals( "1", configs.get( "value1" ) );
        Assert.assertEquals( "2", configs.get( "value2" ) );
        Assert.assertEquals( "3", configs.get( "value3" ) );
    }
    
    @SuppressWarnings( "unchecked" )
    private Map<String, Object> getConfigs( MvcResult result ) {
        Map<String, Object> configs = (Map<String, Object>) result.getModelAndView().getModel().get( "configs" );
        return configs;
    }
}
