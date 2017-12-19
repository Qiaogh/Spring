package com.qiaogh.config;

import com.qiaogh.interceptor.TimeBasedAccessInterceptor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfig;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan( basePackages = "com.qiaogh", includeFilters = {
        @ComponentScan.Filter( Controller.class )
} )
public class MvcConfig extends WebMvcConfigurerAdapter {



    @Bean
    @SuppressWarnings( "deprecation" )
    public VelocityConfig velocityConifg() {
        VelocityConfigurer velocityConfig = new VelocityConfigurer();
        velocityConfig.setResourceLoaderPath( "/WEB-INF/velocity/" );
        return velocityConfig;
    }

    /*
     * Configure View Resolver
     */
    @Bean
    @SuppressWarnings( "deprecation" )
    public ViewResolver viewResolver() {
        VelocityViewResolver viewResolver = new VelocityViewResolver();
        viewResolver.setCache( true );
        viewResolver.setSuffix( ".vm" );
        return viewResolver;
    }

    /*
     * Configure MessageSource to provide internationalized messages
     *
     */

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        // 对应 messages.properties
        messageSource.setBasename( "messages" );
        return messageSource;
    }

    @Override
    public void addResourceHandlers( ResourceHandlerRegistry registry ) {
        registry.addResourceHandler( "/static/**" ).addResourceLocations( "/static/" );
        registry.addResourceHandler( "/**" ).addResourceLocations( "/" );
    }

    @Override
    public void addInterceptors( InterceptorRegistry registry ) {
        TimeBasedAccessInterceptor interceptor = new TimeBasedAccessInterceptor();
        interceptor.setOpeningTime( 8 );
        interceptor.setClosingTime( 16 );
        registry.addInterceptor( interceptor );
    }
}
