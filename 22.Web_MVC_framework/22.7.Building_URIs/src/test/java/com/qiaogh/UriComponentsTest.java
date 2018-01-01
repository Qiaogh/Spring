package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class UriComponentsTest {

    @Test
    public void testExpand() {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString( "http://example.com/hotels/{hotel}/bookings/{booking}" ).build();
        String uriString = uriComponents.expand( "41", "42" ).toUriString();
        Assert.assertEquals("http://example.com/hotels/41/bookings/42", uriString );
    }

    @Test
    public void testEncode() {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString( "http://example.com/hotels/{hotel}/bookings/{booking}" ).build();
        String uriString = uriComponents.expand( "乔", "国欢" ).encode().toUriString();
        Assert.assertEquals( "http://example.com/hotels/%E4%B9%94/bookings/%E5%9B%BD%E6%AC%A2", uriString );
    }
}
