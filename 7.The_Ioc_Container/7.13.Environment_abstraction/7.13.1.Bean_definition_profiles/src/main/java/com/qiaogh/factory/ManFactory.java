package com.qiaogh.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.qiaogh.domain.Man;

@Configuration
public class ManFactory {

    @Bean
    @Profile( "gh" )
    public Man qiaogh() {
        return new Man( "1", "Qiaogh", 26 );
    }
    
    @Bean
    @Profile( "gw" )
    public Man qiaogw() {
        return new Man( "2", "Qiaogw", 24 );
    }
}
