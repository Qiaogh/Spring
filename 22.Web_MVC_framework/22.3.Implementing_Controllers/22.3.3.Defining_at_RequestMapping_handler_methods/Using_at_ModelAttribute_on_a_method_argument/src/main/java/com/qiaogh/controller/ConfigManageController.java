package com.qiaogh.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qiaogh.domain.Person;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {
    
    @ModelAttribute( "p" )
    public Person person() {
        return new Person( "Qiaogh" );
    }
    
    @RequestMapping( "/autoBinding" )
    public ModelAndView autoBinding( @ModelAttribute( "p" ) Person person ) {
        ModelAndView mv = new ModelAndView( "config/autoBinding" );
        mv.addObject( person );
        return mv;
    }
    
    @RequestMapping( "/unBinding" )
    public ModelAndView unBinding( @ModelAttribute( binding = false ) Person person ) {
        ModelAndView mv = new ModelAndView( "config/unBinding" );
        mv.addObject( person );
        return mv;
    }
    
    @RequestMapping( "/validateBinding" )
    public ModelAndView vaildateBinding( @Valid @ModelAttribute( "p" ) Person person, Errors errors ) {
        String viewName = errors.hasErrors() ? "config/validateErrors" : "config/validateBinding";
        ModelAndView mv = new ModelAndView();
        mv.setViewName( viewName );
        return mv;
    }
}
