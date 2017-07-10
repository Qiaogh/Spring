package com.qiaogh.factory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qiaogh.domain.Women;

@Configuration
public class WifeFactory {

    @Bean
    @Qualifier( "qiy" )
    public static Women qiy() {
        return new Women( "qiy" );
    }
    
    @Bean
    @Qualifier( "yy" )
    public static Women yy() {
        return new Women( "yy" );
    }
}
