package com.qiaogh.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qiaogh.domain.Man;

@Controller
@RequestMapping( "/family" )
public class FamilyController implements ApplicationContextAware {

    private ApplicationContext cxt;
    
    @RequestMapping( value = "/man", method = RequestMethod.GET )
    public String man() {
        Man qiaogh = cxt.getBean( Man.class );
        System.out.println( qiaogh );
        return "man";
    }

    public ApplicationContext getApplicationContext() {
        return cxt;
    }

    public void setApplicationContext( ApplicationContext applicationContext ) {
        this.cxt = applicationContext;
    }
}
