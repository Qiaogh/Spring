package com.qiaogh.config;

import com.qiaogh.interceptor.TimeBasedAccessInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@PropertySource( "classpath:freemarker.properties" )
@ComponentScan( basePackages = "com.qiaogh", includeFilters = {
        @ComponentScan.Filter( Controller.class )
} )
public class MvcConfig extends WebMvcConfigurerAdapter {


    @Bean
    public FreeMarkerConfig freeMarkerConfigurer(
            @Value( "${freemarker.templateLoaderPath}" ) String temppateLoaderPath,
            @Value( "${freemarker.defaultEncoding}" ) String defaultEncoding
    ) {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath( temppateLoaderPath );
        freeMarkerConfigurer.setDefaultEncoding( defaultEncoding );
        return freeMarkerConfigurer;
    }

    /*
     * Configure View Resolver
     */
    @Bean
    @SuppressWarnings( "deprecation" )
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setCache( true );
        viewResolver.setSuffix( ".ftl" );
        viewResolver.setRequestContextAttribute( "rc" );
        viewResolver.setContentType( MediaType.TEXT_HTML + ";charset=utf-8" );
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
        interceptor.setClosingTime( 24 );
        registry.addInterceptor( interceptor );
    }
}
