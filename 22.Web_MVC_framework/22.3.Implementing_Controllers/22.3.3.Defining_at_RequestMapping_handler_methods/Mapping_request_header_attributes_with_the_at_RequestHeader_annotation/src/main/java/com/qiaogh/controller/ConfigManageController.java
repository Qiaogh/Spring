package com.qiaogh.controller;

import com.qiaogh.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {
    
    @RequestMapping( "/header" )
    public ModelAndView header( @RequestHeader String name, @RequestHeader Integer age ) {
        Person person = new Person();
        person.setName( name );
        person.setAge( age );
        ModelAndView mv = new ModelAndView( "config/header" );
        mv.addObject( person );
        return mv;
    }
}
