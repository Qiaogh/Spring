package com.qiaogh;

import com.qiaogh.config.AppConfig;
import com.qiaogh.config.MvcConfig;
import com.qiaogh.domain.Person;
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

import java.util.Map;


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
    public void testHeader() throws Exception {
        MvcResult result = mvc.perform(
                MockMvcRequestBuilders.get( "/config/header" )
                        .header( "name", "Qiaogh" )
                        .header( "age", "26" ) )
                .andExpect( MockMvcResultMatchers.view().name( "config/header" ) )
                .andExpect( MockMvcResultMatchers.model().attributeExists( "person" ) )
                .andDo( MockMvcResultHandlers.print() )
                .andReturn();

        Map<String, Object> model = result.getModelAndView().getModel();
        Assert.assertNotNull( model );
        Person person = (Person) model.get( "person" );
        Assert.assertNotNull( person );
        Assert.assertEquals( "Qiaogh", person.getName() );
        Assert.assertEquals( Integer.valueOf( 26 ), person.getAge() );
    }
}
