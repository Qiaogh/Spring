package com.qiaogh.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {

    @GetMapping( "/mixture/{value}" )
    public ModelAndView mixture( @PathVariable String value, @MatrixVariable String q ) {
        Map<String, Object> values = new HashMap<String, Object>();
        values.put( "value", value );
        values.put( "q", q );
        
        ModelAndView mv = new ModelAndView();
        mv.addObject( "configs", values );
        mv.setViewName( "config/mixture" );
        return mv;
    }
    
    @GetMapping( "/pathVar/{value1}/{value2}/{value3}" )
    public ModelAndView pathVar(
            @MatrixVariable( name = "q", pathVar = "value1" ) String value1,
            @MatrixVariable( name = "q", pathVar = "value2" ) String value2,
            @MatrixVariable( name = "q", pathVar = "value3" ) String value3 ) {
        Map<String, Object> values = new HashMap<String, Object>();
        values.put( "value1", value1 );
        values.put( "value2", value2 );
        values.put( "value3", value3 );

        ModelAndView mv = new ModelAndView();
        mv.addObject( "configs", values );
        mv.setViewName( "config/pathVar" );
        return mv;
    }
    
    @GetMapping( "/defaultValue/{value}" )
    public ModelAndView defaultValue(
            @MatrixVariable( required = false, defaultValue = "default" ) String value ) {
        Map<String, Object> values = new HashMap<String, Object>();
        values.put( "value", value );
        
        ModelAndView mv = new ModelAndView();
        mv.addObject( "configs", values );
        mv.setViewName( "config/defaultValue" );
        return mv;
    }
    
    @GetMapping( "/map/{values}" )
    public ModelAndView map(
            @MatrixVariable MultiValueMap<String, Object> values ) {
        ModelAndView mv = new ModelAndView();
        mv.addObject( "configs", values.toSingleValueMap() );
        mv.setViewName( "config/map" );
        return mv;
    }
}
