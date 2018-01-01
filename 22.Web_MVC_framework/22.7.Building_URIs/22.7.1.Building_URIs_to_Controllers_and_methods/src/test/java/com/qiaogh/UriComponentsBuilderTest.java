package com.qiaogh;

import com.qiaogh.controller.MvcUriComponentsBuilderController;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class UriComponentsBuilderTest {

    @Test
    public void test() {
        UriComponentsBuilder base = ServletUriComponentsBuilder.fromUriString( "http://localhost" );
        MvcUriComponentsBuilder builder = MvcUriComponentsBuilder.relativeTo( base );
        UriComponents uriComponents = builder.withMethodCall( MvcUriComponentsBuilder
                .on( MvcUriComponentsBuilderController.class ).build() ).build();

        Assert.assertEquals( "http://localhost/controller/build", uriComponents.toUriString() );
    }
}
