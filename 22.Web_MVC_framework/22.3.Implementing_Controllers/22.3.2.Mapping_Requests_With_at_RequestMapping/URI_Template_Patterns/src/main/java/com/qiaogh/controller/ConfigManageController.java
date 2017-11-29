package com.qiaogh.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {

    @RequestMapping( "/singleton/{value}" )
    public ModelAndView singleton( @PathVariable String value, HttpServletRequest request ) {
        Map<String, Object> values = new HashMap<String, Object>();
        values.put( "value", value );
        
        ModelAndView mv = new ModelAndView();
        mv.addObject( "configs", values );
        mv.setViewName( "config/singleton" );
        return mv;
    }
    
    @RequestMapping( "/simpleMulti/{value1}/{value2}/{value3}" )
    public ModelAndView simpleMulti(
            @PathVariable String value1,
            @PathVariable String value2,
            @PathVariable String value3 ) {
        Map<String, Object> values = new HashMap<String, Object>();
        values.put( "value1", value1 );
        values.put( "value2", value2 );
        values.put( "value3", value3 );

        ModelAndView mv = new ModelAndView();
        mv.addObject( "configs", values );
        mv.setViewName( "config/simpleMulti" );
        return mv;
    }
}
