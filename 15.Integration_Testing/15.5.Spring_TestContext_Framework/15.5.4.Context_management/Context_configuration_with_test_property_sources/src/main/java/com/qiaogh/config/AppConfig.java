package com.qiaogh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.qiaogh.domain.Person;

@Configuration
@Import( Person.class )
@PropertySource( "classpath:qiaogh.properties" )
public class AppConfig {

}
