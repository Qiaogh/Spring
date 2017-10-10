package com.qiaogh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.qiaogh.domain.Person;

@Configuration
@Profile( "village" )
public class VillageProfile {

    @Bean
    public Person qiaogh() {
        Person qiaogh = new Person( "1", "Qiaogh", 26 );
        qiaogh.setStatus( "village" );
        return qiaogh;
    }
}
