package com.qiaogh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan( basePackages = "com.qiaogh", includeFilters = {
    @ComponentScan.Filter( type = FilterType.ANNOTATION, value = Controller.class )
})
public class MvcConfig extends WebMvcConfigurerAdapter {
    
}
