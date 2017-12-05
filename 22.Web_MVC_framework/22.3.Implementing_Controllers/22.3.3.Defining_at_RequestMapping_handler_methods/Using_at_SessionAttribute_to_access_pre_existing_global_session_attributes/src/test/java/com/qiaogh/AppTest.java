package com.qiaogh;

import java.util.Map;

import com.qiaogh.domain.Person;
import com.qiaogh.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
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
    private MockHttpSession session;
    
    @Before
    public void before() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup( context ).build();
        MvcResult result = mvc.perform( MockMvcRequestBuilders.post( "/login" )
                .param( "name", "Qiaogh" )
                .param( "age", "26" ) ).andReturn();
        
        session = (MockHttpSession) result.getRequest().getSession();
    }
    
    @Test
    public void testInfo() throws Exception {
        MvcResult result = mvc.perform(
                    MockMvcRequestBuilders.get( "/userManage/info" )
                    .session( session ) )
                .andExpect( MockMvcResultMatchers.view().name( "userManage/info" ) )
                .andExpect( MockMvcResultMatchers.model().attributeExists( "user" ) )
                .andDo( MockMvcResultHandlers.print() )
                .andReturn();
        
        Map<String, Object> model = result.getModelAndView().getModel();
        User user = (User) model.get( "user" );
        Assert.assertNotNull( user );
        Assert.assertEquals( "Qiaogh", user.getName() );
        Assert.assertEquals( Integer.valueOf( 26 ), user.getAge() );
    }
}
