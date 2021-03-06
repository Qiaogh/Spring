package com.qiaogh;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    public void testJson() throws Exception {
        MvcResult result = mvc.perform(
                    MockMvcRequestBuilders.post( "/config/testJson" )
                    .contentType( MediaType.APPLICATION_JSON )
                    .content( "{ 'name': 'Qiaogh', 'age': '26' }" ) )
                .andExpect( MockMvcResultMatchers.view().name( "config/testJson" ) )
                .andExpect( MockMvcResultMatchers.model().attributeExists( "name", "age" ) )
                .andDo( MockMvcResultHandlers.print() )
                .andReturn();
        
        Map<String, Object> model = result.getModelAndView().getModel();
        Assert.assertNotNull( model );
        Assert.assertEquals( "Qiaogh", model.get( "name" ) );
        Assert.assertEquals( "26", model.get( "age" ) );
    }
    
    /// 乔国欢 2017-11-29 16:49:00
//    @Test
//    public void testXml() throws Exception {
//        MvcResult result = mvc.perform(
//                    MockMvcRequestBuilders.post( "/config/testXml" )
//                    .contentType( MediaType.APPLICATION_XML )
//                    .content( "<>" ) )
//                .andExpect( MockMvcResultMatchers.view().name( "config/testXml" ) )
//                .andExpect( MockMvcResultMatchers.model().attributeExists( "person" ) )
//                .andReturn();
//        
//        Map<String, Object> model = result.getModelAndView().getModel();
//        Assert.assertNotNull( model );
//    }
}
