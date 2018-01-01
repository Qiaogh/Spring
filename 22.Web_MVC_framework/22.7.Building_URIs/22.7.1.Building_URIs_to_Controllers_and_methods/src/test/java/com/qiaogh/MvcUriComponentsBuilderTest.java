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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith( SpringRunner.class )
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration( name = "root", classes = AppConfig.class ),
        @ContextConfiguration( name = "mvc", classes = MvcConfig.class )
})
public class MvcUriComponentsBuilderTest {

    @Autowired
    private WebApplicationContext cxt;

    private MockMvc mvc;

    @Before
    public void before() {
        mvc = MockMvcBuilders.webAppContextSetup( cxt ).build();
    }

    @Test
    public void testFromController() throws Exception {
        UriComponents uriComponents = build( "fromController" );
        Assert.assertEquals( "http://localhost/controller", uriComponents.toUriString() );
    }

    @Test
    public void testFromMethodName() throws Exception {
        UriComponents uriComponents = build( "fromMethodName" );
        Assert.assertEquals( "http://localhost/controller/build", uriComponents.toUriString() );
    }

    @Test
    public void testFromMethodCall() throws Exception {
        UriComponents uriComponents = build( "fromMethodCall" );
        Assert.assertEquals( "http://localhost/controller/build", uriComponents.toUriString() );
    }

    private UriComponents build( String attribute ) throws Exception {
        return build( new String[] { attribute } ).get( 0 );
    }

    private List<UriComponents> build( String... attributes ) throws Exception {
        MvcResult result = mvc.perform( MockMvcRequestBuilders.get( "/controller/build" ) )
                .andExpect( MockMvcResultMatchers.model().attributeExists( attributes ) )
                .andDo( MockMvcResultHandlers.print() )
                .andReturn();

        Map<String, Object> model = result.getModelAndView().getModel();
        List<UriComponents> uriComponenties = new ArrayList<>( attributes.length );
        for ( String attribute : attributes ) {
            uriComponenties.add( (UriComponents) model.get( attribute ) );
        }
        return uriComponenties;
    }
}
