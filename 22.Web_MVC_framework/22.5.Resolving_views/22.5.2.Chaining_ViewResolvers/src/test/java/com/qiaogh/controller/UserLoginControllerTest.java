package com.qiaogh.controller;

import com.qiaogh.config.AppConfig;
import com.qiaogh.config.MvcConfig;
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
    public void test() throws Exception {
        mvc.perform(
                    MockMvcRequestBuilders.post( "/login" )
                        .param( "name", "Qiaogh" )
                        .param( "password", "123" ) )
                .andExpect( MockMvcResultMatchers.model().attributeExists( "user" ) )
//                .andExpect( MockMvcResultMatchers.forwardedUrl( "/WEB-INF/views/success.jsp" ) )
                .andDo( MockMvcResultHandlers.print() )
                .andReturn();
    }
}
