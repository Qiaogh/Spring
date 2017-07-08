package com.qiaogh.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qiaogh.annotation.Keyword;
import com.qiaogh.domain.Women;

@Configuration
public class WifeFactory {

    @Bean
    @Keyword( "qiy" )
    public static Women qiy() {
        return new Women( "2", "Qiy" );
    }

    @Bean
    @Keyword( "yy" )
    public static Women yy() {
        return new Women( "3", "YY" );
    }
}
