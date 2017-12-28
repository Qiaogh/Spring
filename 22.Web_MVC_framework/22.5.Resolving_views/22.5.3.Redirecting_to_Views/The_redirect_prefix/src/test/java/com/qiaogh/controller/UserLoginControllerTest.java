package com.qiaogh.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qiaogh.config.AppConfig;
import com.qiaogh.config.MvcConfig;
import com.qiaogh.domain.User;
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
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

@RunWith( SpringRunner.class )
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration( name = "root", classes = AppConfig.class ),
        @ContextConfiguration( name = "mvc", classes = MvcConfig.class )
})
public class UserLoginControllerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;

    @Before
    public void before() {
        mvc = MockMvcBuilders.webAppContextSetup( context ).build();
    }

    @Test
    public void testLogin() throws Exception {
        mvc.perform(
                    MockMvcRequestBuilders.post( "/login" )
                        .param( "name", "Qiaogh" )
                        .param( "password", "123" ) )
                .andExpect( MockMvcResultMatchers.model().attributeExists( "user" ) )
                .andExpect( MockMvcResultMatchers.redirectedUrl( "success?user=%7B%22id%22%3A2147483647%2C%22name%22%3A%22Qiaogh%22%2C%22password%22%3A%22123%22%2C%22age%22%3A26%7D" ) )
                .andDo( MockMvcResultHandlers.print() )
                .andReturn();
    }

    @Test
    public void testError() throws Exception {
        mvc.perform( MockMvcRequestBuilders.post( "/login" ) )
                .andExpect( MockMvcResultMatchers.redirectedUrl( "error" ) )
                .andDo( MockMvcResultHandlers.print() )
                .andReturn();
    }

    @Test
    public void testSuccess() throws Exception {
        MvcResult result = mvc.perform(
                MockMvcRequestBuilders.post( "/success" ).param( "user", "{\"id\":2147483647,\"name\":\"Qiaogh\",\"password\":\"123\",\"age\":26}" ) )
                .andExpect( MockMvcResultMatchers.model().attributeExists( "user" ) )
                .andDo( MockMvcResultHandlers.print() )
                .andReturn();

        Map<String, Object> model = result.getModelAndView().getModelMap();
        User user = (User) model.get( "user" );
        Assert.assertEquals( Integer.valueOf( 2147483647 ), user.getId() );
        Assert.assertEquals( "Qiaogh", user.getName() );
        Assert.assertTrue( StringUtils.isEmpty( user.getPassword() ) );
        Assert.assertEquals( Integer.valueOf( 26 ), user.getAge() );
    }
}
