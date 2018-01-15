package com.qiaogh.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup( ServletContext servletContext ) throws ServletException {
        AnnotationConfigWebApplicationContext cxt = new AnnotationConfigWebApplicationContext();
        cxt.register( AppConfig.class );

        ContextLoader loader = new ContextLoader( cxt );
        loader.initWebApplicationContext( servletContext );

        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setContextConfigLocation( "WEB-INF/spring-servlet-config.xml" );

        ServletRegistration.Dynamic registration = servletContext.addServlet( "dispatcher", dispatcherServlet );
        registration.setLoadOnStartup( 1 );
        registration.addMapping( "/" );
    }
}
