package com.qiaogh.controller;

import com.qiaogh.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {
    
    @RequestMapping( "/request" )
    public ModelAndView request( @RequestAttribute String name, @RequestAttribute Integer age ) {
        Person person = new Person();
        person.setName( name );
        person.setAge( age );
        ModelAndView mv = new ModelAndView( "config/request" );
        mv.addObject( person );
        return mv;
    }
}
