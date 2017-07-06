package com.qiaogh.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qiaogh.annotation.Keyword;
import com.qiaogh.domain.Wife;

@Configuration
public class WifeFactory {

    @Bean
    @Keyword( "qiy" )
    public Wife qiy() {
        return new Wife( "Qiy" );
    }
    
    @Bean
    @Keyword( "yy" )
    public Wife yy() {
        return new Wife( "Yy" );
    }
}
