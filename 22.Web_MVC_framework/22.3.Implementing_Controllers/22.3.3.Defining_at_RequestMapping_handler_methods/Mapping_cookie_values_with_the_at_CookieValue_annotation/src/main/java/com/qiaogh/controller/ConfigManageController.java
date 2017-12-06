package com.qiaogh.controller;

import com.qiaogh.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {
    
    @RequestMapping( "/cookie" )
    public ModelAndView cookie( @CookieValue( "name" ) String name, @CookieValue( "age" ) Integer age ) {
        Person person = new Person();
        person.setName( name );
        person.setAge( age );
        ModelAndView mv = new ModelAndView( "config/cookie" );
        mv.addObject( person );
        return mv;
    }
}
