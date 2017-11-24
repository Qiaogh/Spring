package com.qiaogh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.castor.CastorMarshaller;

@Configuration
public class AppConfig {

    @Bean
    public CastorMarshaller castorMarshaller() {
        return new CastorMarshaller();
    }
}
