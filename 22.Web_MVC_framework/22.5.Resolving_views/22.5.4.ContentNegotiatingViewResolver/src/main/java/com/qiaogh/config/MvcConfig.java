package com.qiaogh.config;

import com.qiaogh.domain.User;
import com.qiaogh.resolver.ExcelViewResolver;
import com.qiaogh.resolver.Jaxb2MarshallingXmlViewResolver;
import com.qiaogh.resolver.JsonViewResolver;
import com.qiaogh.resolver.PdfViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.ArrayList;
import java.util.List;

@EnableWebMvc
@ComponentScan( basePackages = "com.qiaogh", includeFilters = {
        @ComponentScan.Filter( Controller.class )
} )
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureContentNegotiation( ContentNegotiationConfigurer configurer ) {
        configurer.ignoreAcceptHeader( true ).defaultContentType( MediaType.TEXT_HTML );
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver( ContentNegotiationManager manager ) {
        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();

        viewResolver.setContentNegotiationManager( manager );

        List<ViewResolver> viewResolvers = new ArrayList<>( 5 );
        viewResolvers.add( jaxb2MarshallingXmlViewResolver() );
        viewResolvers.add( jsonViewResolver() );
        viewResolvers.add( pdfViewResolver() );
        viewResolvers.add( excelViewResolver() );
        viewResolvers.add( jspViewResolver() );

        viewResolver.setViewResolvers( viewResolvers );
        return viewResolver;
    }

    @Bean
    public ViewResolver jaxb2MarshallingXmlViewResolver() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound( User.class );
        return new Jaxb2MarshallingXmlViewResolver( marshaller );
    }

    @Bean
    public ViewResolver jsonViewResolver() {
        return new JsonViewResolver();
    }

    @Bean
    public ViewResolver pdfViewResolver() {
        return new PdfViewResolver();
    }

    @Bean
    public ViewResolver excelViewResolver() {
        return new ExcelViewResolver();
    }

    @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass( JstlView.class );
        viewResolver.setPrefix( "/WEB-INF/jsp/" );
        viewResolver.setSuffix( ".jsp" );
        return viewResolver;
    }
}
