package com.qiaogh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan( basePackages = "com.qiaogh", includeFilters = {
        @ComponentScan.Filter({
                Controller.class,
                Service.class
        })
} )
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix( "/WEB-INF/templates/" );
        templateResolver.setSuffix( ".html" );
        templateResolver.setTemplateMode( TemplateMode.HTML );
        return templateResolver;
    }

    @Bean
    public ITemplateEngine templateEngine() {
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver( templateResolver() );
        return templateEngine;
    }

    /*
     * Configure View Resolver
     */
    @Bean
    @SuppressWarnings( "deprecation" )
    public ViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine( templateEngine() );
        return viewResolver;
    }

    @Override
    public void addResourceHandlers( ResourceHandlerRegistry registry ) {
        registry.addResourceHandler( "/css/*" ).addResourceLocations( "/css/" );
        registry.addResourceHandler( "/images/*" ).addResourceLocations( "/images/" );
    }
}
