package com.qiaogh.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qiaogh.domain.Women;

@Configuration
public class WifeFactory {

    @Bean( "qiy" )
    public static Women qiy() {
        return new Women( "Qiy" );
    }
    
    @Bean( "qiy" )
    public static Women yy() {
        return new Women( "YY" );
    }
}
