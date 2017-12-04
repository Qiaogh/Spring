package com.qiaogh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.castor.CastorMarshaller;

@SuppressWarnings( "deprecation" )
@Configuration
public class AppConfig {

    @Bean
    public Marshaller castorMarshaller( ResourceLoader loader ) {
        CastorMarshaller cm = new CastorMarshaller();
        cm.setMappingLocations( loader.getResource( "classpath:settings-mapping.xml" ) );
        return cm;
    }
}
