package com.qiaogh.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {

    @RequestMapping( "/simple" )
    public ModelAndView simple( @RequestParam( "value" ) String value ) {
        ModelAndView mv = new ModelAndView();
        mv.addObject( "value", value );
        mv.setViewName( "config/simple" );
        return mv;
    }

    @RequestMapping( "/defaultValue" )
    public ModelAndView defaultValue( @RequestParam( name = "value", defaultValue = "Qiaogh" ) String value ) {
        ModelAndView mv = new ModelAndView();
        mv.addObject( "value", value );
        mv.setViewName( "config/defaultValue" );
        return mv;
    }
    
    @RequestMapping( "/requiredValue" )
    public ModelAndView requiredValue( @RequestParam( name = "value" ) String value ) {
        ModelAndView mv = new ModelAndView();
        mv.addObject( "value", value );
        mv.setViewName( "config/requiredValue" );
        return mv;
    }
    
    @RequestMapping( "/mapValue" )
    public ModelAndView mapValue( @RequestParam Map<String, Object> values ) {
        ModelAndView mv = new ModelAndView( "config/mapValue" );
        mv.addAllObjects( values );
        return mv;
    }
}
