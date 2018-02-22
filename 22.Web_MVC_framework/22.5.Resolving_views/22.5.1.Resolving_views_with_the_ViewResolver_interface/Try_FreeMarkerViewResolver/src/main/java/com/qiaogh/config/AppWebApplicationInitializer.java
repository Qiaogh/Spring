package com.qiaogh.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import java.util.LinkedHashSet;

public class AppWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup( ServletContext servletContext ) {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register( AppConfig.class );
        ctx.register( MvcConfig.class );
        ctx.setServletContext( servletContext );

        ServletRegistration.Dynamic servlet = servletContext.addServlet( "dispatcher", new DispatcherServlet( ctx ) );
        servlet.setLoadOnStartup( 1 );
        servlet.addMapping( "/" );
    }

}
