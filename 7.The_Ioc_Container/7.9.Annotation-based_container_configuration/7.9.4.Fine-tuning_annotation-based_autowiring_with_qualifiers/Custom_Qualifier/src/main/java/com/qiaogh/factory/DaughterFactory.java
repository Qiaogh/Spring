package com.qiaogh.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qiaogh.annotation.Birthmark;
import com.qiaogh.domain.Daughter;

@Configuration
public class DaughterFactory {

    @Bean
    public Daughter qiaoxl() {
        return new Daughter( "qiaoxl" );
    }
    
    @Bean
    @Birthmark
    public Daughter qiaoxh() {
        return new Daughter( "qiaoxh" );
    }
}
