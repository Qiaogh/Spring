package com.qiaogh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.qiaogh.domain.Man;
import com.qiaogh.domain.Women;

@Configuration
@ImportResource( locations = "classpath:properties-config.xml" )
public class Family {

    @Bean
    public Man qiaogh() {
        return new Man();
    }
    
    @Bean
    public Women qiy() {
        return new Women();
    }
}
