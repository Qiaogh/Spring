package com.qiaogh.config;

import com.qiaogh.interceptor.TimeBasedAccessInterceptor;
import org.apache.velocity.runtime.RuntimeConstants;
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
import org.springframework.web.servlet.view.velocity.VelocityConfig;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebMvc
@PropertySource( "classpath:velocity.properties" )
@ComponentScan( basePackages = "com.qiaogh", includeFilters = {
        @ComponentScan.Filter( Controller.class )
} )
public class MvcConfig extends WebMvcConfigurerAdapter {



    @Bean
    @SuppressWarnings( "deprecation" )
    public VelocityConfig velocityConifgurer(
            @Value( "${velocity.input.encoding}" ) String inputEncoding,
            @Value( "${velocity.output.encoding}" ) String outputEncoding
    ) {
        VelocityConfigurer velocityConfig = new VelocityConfigurer();
        velocityConfig.setResourceLoaderPath( "/WEB-INF/velocity/" );

        Map<String, Object> properties = new HashMap<>( 2 );
        properties.put( RuntimeConstants.INPUT_ENCODING, inputEncoding );
        properties.put( RuntimeConstants.OUTPUT_ENCODING, outputEncoding );
        velocityConfig.setVelocityPropertiesMap( properties );
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
