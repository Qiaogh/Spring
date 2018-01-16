package com.qiaogh.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.context.ThemeSource;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan( basePackages = "com.qiaogh", includeFilters = {
        @ComponentScan.Filter( Controller.class )
})
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors( InterceptorRegistry registry ) {
        String paramName = "locale";

        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        ThemeChangeInterceptor themeChangeInterceptor = new ThemeChangeInterceptor();

        localeChangeInterceptor.setParamName( paramName );
        themeChangeInterceptor.setParamName( paramName );

        registry.addInterceptor( localeChangeInterceptor );
        registry.addInterceptor( themeChangeInterceptor );
    }

    @Override
    public void configureViewResolvers( ViewResolverRegistry registry ) {
        registry.viewResolver( viewResolver() );
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass( JstlView.class );
        viewResolver.setPrefix( "/WEB-INF/views/" );
        viewResolver.setSuffix( ".jsp" );
        return viewResolver;
    }

    @Override
    public void configureDefaultServletHandling( DefaultServletHandlerConfigurer configurer ) {
        configurer.enable();
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new CookieLocaleResolver();
    }

    @Bean
    public ThemeResolver themeResolver() {
        return new CookieThemeResolver();
    }

    @Bean
    public MultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }

    @Bean
    public ThemeSource themeSource() {
        ResourceBundleThemeSource themeSource = new ResourceBundleThemeSource();
        themeSource.setBasenamePrefix( "theme_" );
        return themeSource;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames( "messages", "labels" );
        return messageSource;
    }
}
