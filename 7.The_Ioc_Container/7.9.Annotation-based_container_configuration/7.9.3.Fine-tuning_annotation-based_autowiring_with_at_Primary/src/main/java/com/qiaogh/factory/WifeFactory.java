package com.qiaogh.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.qiaogh.domain.Wife;

@Configuration
public class WifeFactory {

    @Bean
    @Primary
    public Wife madam() {
        return new Wife( "Qiy" );
    }
    
    @Bean
    public Wife concubine() {
        return new Wife( "YY" );
    }
}
