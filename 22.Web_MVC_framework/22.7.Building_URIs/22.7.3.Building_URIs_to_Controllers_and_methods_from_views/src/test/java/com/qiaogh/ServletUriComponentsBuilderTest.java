package com.qiaogh;

import com.qiaogh.config.AppConfig;
import com.qiaogh.config.MvcConfig;
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
import org.springframework.web.util.UriComponents;

import java.util.Map;

@RunWith( SpringRunner.class )
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration( name = "root", classes = AppConfig.class ),
        @ContextConfiguration( name = "mvc", classes = MvcConfig.class )
})
public class ServletUriComponentsBuilderTest {

    @Autowired
    private WebApplicationContext cxt;

    private MockMvc mvc;

    @Before
    public void before() {
        mvc = MockMvcBuilders.webAppContextSetup( cxt ).build();
    }

    @Test
    public void testFromRequest() throws Exception {
        MvcResult result = mvc.perform( MockMvcRequestBuilders.get( "/controller/build" ) )
                .andExpect( MockMvcResultMatchers.model().attributeExists( "fromMappingName" ) )
                .andDo( MockMvcResultHandlers.print() )
                .andReturn();
        Map<String, Object> model = result.getModelAndView().getModel();
        UriComponents uriComponents = (UriComponents) model.get( "fromMappingName" );
        Assert.assertEquals( "/controller/build", uriComponents.toUriString() );
    }
}
