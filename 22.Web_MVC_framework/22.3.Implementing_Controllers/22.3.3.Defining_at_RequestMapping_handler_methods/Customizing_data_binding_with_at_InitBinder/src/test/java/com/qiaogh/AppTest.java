package com.qiaogh;

import com.qiaogh.config.AppConfig;
import com.qiaogh.config.MvcConfig;
import com.qiaogh.domain.Person;
import org.apache.commons.lang3.time.DateUtils;
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


/**
 * Unit test for simple App.
 */
@RunWith( SpringRunner.class )
@WebAppConfiguration
@ContextHierarchy( value = {
        @ContextConfiguration( name = "root", classes = AppConfig.class ),
        @ContextConfiguration( name = "mvc", classes = MvcConfig.class )
} )
public class AppTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;

    @Before
    public void before() {
        mvc = MockMvcBuilders.webAppContextSetup( context ).build();
    }

    @Test
    public void testFormatter() throws Exception {
        MvcResult result = mvc.perform(
                    MockMvcRequestBuilders.get( "/config/formatter" )
                    .param( "age", "26" )
                    .param( "birthday", "1988-10-07" ) )
                .andExpect( MockMvcResultMatchers.view().name( "config/formatter" ) )
                .andExpect( MockMvcResultMatchers.model().attributeExists( "p" ) )
                .andDo( MockMvcResultHandlers.print() )
                .andReturn();

        Person person = (Person) result.getModelAndView().getModel().get( "p" );
        Assert.assertNotNull( person );
        Assert.assertEquals( "Qiaogh", person.getName() );
        Assert.assertEquals( Integer.valueOf( 26 ), person.getAge() );
        Assert.assertTrue( DateUtils.isSameDay( DateUtils.parseDate( "1988-10-07", "yyyy-MM-dd" ), person.getBirthday() ) );
    }

    @Test
    public void testValidateBinding() throws Exception {
        mvc.perform( MockMvcRequestBuilders.get( "/config/validateBinding" )
                .param( "age", "0" ) )
                .andExpect( MockMvcResultMatchers.view().name( "config/validateErrors" ) )
                .andDo( MockMvcResultHandlers.print() )
                .andReturn();
    }
}
