package com.qiaogh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;

@Configuration
@PropertySource( "classpath:log4j.properties" )
@ComponentScan( basePackages = "com.qiaogh", excludeFilters = {
        @ComponentScan.Filter( Controller.class )
})
public class AppConfig {
}
