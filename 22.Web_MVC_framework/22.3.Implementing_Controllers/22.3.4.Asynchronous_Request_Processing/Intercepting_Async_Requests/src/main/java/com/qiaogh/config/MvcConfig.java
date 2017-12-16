package com.qiaogh.config;

import com.qiaogh.interceptor.AuthorityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan( value = "com.qiaogh", includeFilters = {
        @ComponentScan.Filter( Controller.class )
})
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors( InterceptorRegistry registry ) {
        registry.addInterceptor( new AuthorityInterceptor() );
    }
}
