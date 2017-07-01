package com.qiaogh.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qiaogh.domain.IPerson;

@Controller
@RequestMapping( "/scopeController" )
public class ScopeController implements ApplicationContextAware {
    
    private static ApplicationContext context;

    @RequestMapping( value = "/process", method = RequestMethod.GET )
    public String process() {
        IPerson person = (IPerson) context.getBean( "session" );
        IPerson person2 = (IPerson) context.getBean( "request" );
        System.out.println( person );
        System.out.println( person.getRequest() );
        System.out.println( person2 );
        return "scope";
    }

    @Override
    public void setApplicationContext( ApplicationContext applicationContext ) throws BeansException {
        context = applicationContext;
    }
    
}
