package com.qiaogh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qiaogh.domain.Person;

@Configuration
public class AppConfig {

    @Bean
    public Person root() {
        return new Person( "1", "Qiaogh", 26 );
    }
}
