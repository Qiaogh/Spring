package com.qiaogh.controller;

import com.qiaogh.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {
    
    @ModelAttribute( "p" )
    public Person person() {
        return new Person( "Qiaogh" );
    }

    @RequestMapping( "/formatter" )
    public ModelAndView formatter( @ModelAttribute( "p" ) Person person ) {
        return new ModelAndView( "config/formatter" );
    }

    @RequestMapping( "/validateBinding" )
    public ModelAndView vaildateBinding( @Validated @ModelAttribute( "p" ) Person person, Errors errors ) {
        String viewName = errors.hasErrors() ? "config/validateErrors" : "config/validateBinding";
        ModelAndView mv = new ModelAndView();
        mv.setViewName( viewName );
        return mv;
    }
}
