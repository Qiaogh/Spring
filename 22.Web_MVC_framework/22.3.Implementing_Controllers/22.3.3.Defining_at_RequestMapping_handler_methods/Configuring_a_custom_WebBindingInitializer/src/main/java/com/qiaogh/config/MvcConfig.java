package com.qiaogh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan( basePackages = "com.qiaogh", includeFilters = {
    @ComponentScan.Filter( type = FilterType.ANNOTATION, value = Controller.class )
})
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public HandlerAdapter handlerAdapter( WebBindingInitializer webBindingInitializer ) {
        RequestMappingHandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
        handlerAdapter.setOrder( Integer.MIN_VALUE );
        handlerAdapter.setCacheSeconds( 0 );
        handlerAdapter.setWebBindingInitializer( webBindingInitializer );
        return handlerAdapter;
    }
}
