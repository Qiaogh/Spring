package com.qiaogh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan( "com.qiaogh" )
public class AppConfig {

    @Bean
    public static ViewResolver buildViewResolver() {
        ViewResolver viewResolver = new InternalResourceViewResolver( "/WEB-INF/jsp/", ".jsp" );
        return viewResolver;
    }
}
