package com.qiaogh.factory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qiaogh.domain.Wife;

@Configuration
public class WifeFactory {

    @Bean
    @Qualifier( "qiy" )
    public Wife qiy() {
        return new Wife( "Qiy" );
    }
    
    @Bean
    @Qualifier( "yy" )
    public Wife yy() {
        return new Wife( "yy" );
    }
}
