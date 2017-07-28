package com.qiaogh.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.env.PropertySource;


public class SimplePropertySource extends PropertySource<String> {

    private Map<String, Object> props = new HashMap<String, Object>();
    
    public SimplePropertySource( String name ) {
        super( name );
        props.put( "name", "Qiaogh" );
    }

    @Override
    public Object getProperty( String name ) {
        return props.get( name );
    }
}
