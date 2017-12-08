package com.qiaogh;

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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Unit test for simple App.
 */
@RunWith( SpringRunner.class )
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration( name = "root", classes = AppConfig.class ),
        @ContextConfiguration( name = "mvc", classes = MvcConfig.class )
})
public class AppTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mv;

    @Before
    public void before() {
        mv = MockMvcBuilders.webAppContextSetup( wac ).build();
    }

    @Test
    public void testJacksonWithoutPassword() throws Exception {
        MvcResult result = mv.perform(
                    MockMvcRequestBuilders.get( "/user/jacksonWithoutPassword" )
                    .param( "name", "Qiaogh" )
                    .param( "password", "123" )
                    .param( "age", "26" )
                    .param( "birthday", "1988-10-07" ) )
                .andReturn();
        System.out.println( result.getResponse().getContentAsString() );
    }
}
