package com.qiaogh.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.qiaogh.domain.Women;

@Configuration
public class WomenFactory {

    @Bean
    @Profile( "qiy" )
    public Women qiy() {
        return new Women( "3", "Qiy", 24 );
    }
    
    @Bean
    @Profile( "zn" )
    public Women zn() {
        return new Women( "4", "Zn", 25 );
    }
}
