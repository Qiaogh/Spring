package com.qiaogh.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
@PropertySource( "classpath:jaxb-marshaller.properties" )
public class AppConfig {

    @Bean
    public Marshaller jaxbMarshaller(
            @Value( "${jaxb.formatted.output}" ) Boolean formattedOutput ) {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        
        Map<String, Object> properties = new HashMap<String, Object>( 1 );
        properties.put( javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, formattedOutput );
        marshaller.setMarshallerProperties( properties );
        
        marshaller.setClassesToBeBound( Settings.class );
        
        return marshaller;
    }
}
