package com.qiaogh;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.qiaogh.config.AppConfig;
import com.qiaogh.config.MvcConfig;
import com.qiaogh.domain.Person;


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
    public void testSession() throws Exception {
        Person person = new Person();
        person.setName( "Qiaogh" );
        person.setAge( 26 );
        
        mvc.perform(
                    MockMvcRequestBuilders.get( "/config/session" )
                    .sessionAttr( "person", person ) )
                .andExpect( MockMvcResultMatchers.view().name( "config/session" ) )
                .andExpect( MockMvcResultMatchers.model().attributeExists( "person" ) )
                .andDo( MockMvcResultHandlers.print() )
                .andReturn();
        
    }
}
