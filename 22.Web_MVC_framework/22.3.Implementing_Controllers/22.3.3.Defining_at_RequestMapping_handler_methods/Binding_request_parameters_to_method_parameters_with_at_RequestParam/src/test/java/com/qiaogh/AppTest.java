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
    public void testSimple() throws Exception {
        MvcResult result = mvc.perform( MockMvcRequestBuilders.get( "/config/simple?value=1" ) )
                .andExpect( MockMvcResultMatchers.view().name( "config/simple" ) )
                .andExpect( MockMvcResultMatchers.model().attributeExists( "value" ) )
                .andDo( MockMvcResultHandlers.print() )
                .andReturn();
        
        Map<String, Object> model = result.getModelAndView().getModel();
        Assert.assertNotNull( model );
        Assert.assertEquals( "1", model.get( "value" ) );
    }
    
    @Test
    public void testDefaultValue() throws Exception {
        MvcResult result = mvc.perform( MockMvcRequestBuilders.get( "/config/defaultValue" ) )
                .andExpect( MockMvcResultMatchers.view().name( "config/defaultValue" ) )
                .andExpect( MockMvcResultMatchers.model().attributeExists( "value" ) )
                .andDo( MockMvcResultHandlers.print() )
                .andReturn();
        
        Map<String, Object> model = result.getModelAndView().getModel();
        Assert.assertNotNull( model );
        Assert.assertEquals( "Qiaogh", model.get( "value" ) );
    }
    
    @Test( expected = AssertionError.class )
    public void testRequiredValue() throws Exception {
        mvc.perform( MockMvcRequestBuilders.get( "/config/requiredValue" ) )
        .andExpect( MockMvcResultMatchers.view().name( "config/requiredValue" ) );
    }
    
    @Test
    public void testMapValue() throws Exception {
        MvcResult result = mvc.perform( MockMvcRequestBuilders.get( "/config/mapValue?name=Qiaogh&age=1" ) )
                .andExpect( MockMvcResultMatchers.view().name( "config/mapValue" ) )
                .andExpect( MockMvcResultMatchers.model().attributeExists( "name", "age" ) )
                .andReturn();
        
        Map<String, Object> model = result.getModelAndView().getModel();
        Assert.assertNotNull( model );
        Assert.assertEquals( "Qiaogh", model.get( "name" ) );
        Assert.assertEquals( "1", model.get( "age" ) );
    }
}
