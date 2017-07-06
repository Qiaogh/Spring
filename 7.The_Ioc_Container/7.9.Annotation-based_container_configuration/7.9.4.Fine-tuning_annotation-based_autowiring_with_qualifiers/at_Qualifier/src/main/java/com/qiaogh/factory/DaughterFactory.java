package com.qiaogh.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qiaogh.domain.Daughter;

@Configuration
public class DaughterFactory {

    @Bean( "qiaoxx" )
    public static Daughter qiaoxx() {
        return new Daughter( "qiaoxx" );
    }
    
    @Bean( "qiaoxh" )
    public static Daughter qiaoxh() {
        return new Daughter( "qiaoxh" );
    }
}
