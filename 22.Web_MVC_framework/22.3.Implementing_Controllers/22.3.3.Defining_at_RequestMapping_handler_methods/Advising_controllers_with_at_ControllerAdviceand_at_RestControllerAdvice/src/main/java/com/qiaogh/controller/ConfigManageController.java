package com.qiaogh.controller;

import com.qiaogh.domain.Person;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {
    
    @RequestMapping( "/formatter" )
    public ModelAndView formatter( @ModelAttribute( "p" ) Person person ) {
        return new ModelAndView( "config/formatter" );
    }

    @RequestMapping( "/validateBinding" )
    public ModelAndView vaildateBinding( @Validated @ModelAttribute( "p" ) Person person, Errors errors ) {
        Validate.isTrue( !errors.hasErrors() );
        return new ModelAndView( "config/validateBinding" );
    }
}
