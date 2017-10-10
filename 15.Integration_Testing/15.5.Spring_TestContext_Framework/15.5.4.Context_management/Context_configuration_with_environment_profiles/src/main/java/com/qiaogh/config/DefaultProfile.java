package com.qiaogh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.qiaogh.domain.Person;

@Configuration
@Profile( "default" )
public class DefaultProfile {

    @Bean
    public Person qiaogh() {
        return new Person( "1", "Qiaogh", 26 );
    }
}
