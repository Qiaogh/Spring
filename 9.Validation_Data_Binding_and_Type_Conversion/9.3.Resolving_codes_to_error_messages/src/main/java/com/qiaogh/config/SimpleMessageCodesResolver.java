package com.qiaogh.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.validation.MessageCodesResolver;

public class SimpleMessageCodesResolver implements MessageCodesResolver {

    private static final ResourceLoader RESOURCE_LOADER = new DefaultResourceLoader();
    private static final Resource RESOURCE = RESOURCE_LOADER.getResource( "classpath:conf/messages.properties" );
    private static Properties properties = null;
    
    static {
        try {
            properties = PropertiesLoaderUtils.loadProperties( RESOURCE );
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String[] resolveMessageCodes( String errorCode, String objectName ) {
        return resolveMessageCodes( errorCode, objectName, null, null );
    }

    @Override
    public String[] resolveMessageCodes( String errorCode, String objectName, String field, Class<?> fieldType ) {
        return String.valueOf( properties.get( errorCode ) ).split( "," );
    }

}
