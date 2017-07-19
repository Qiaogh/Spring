package com.qiaogh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.qiaogh.domain.Man;
import com.qiaogh.domain.Women;

@Configuration
@Import({
    Man.class,
    Women.class
})
@Profile( "produce" )
public class ProduceAppConfig {

}
