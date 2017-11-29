package com.qiaogh.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {

    @RequestMapping( "/regular/{name:[a-z-]+}-{version:\\d\\.\\d\\.\\d}.{extension:[a-z]+}" )
    public ModelAndView regular( @PathVariable String name, @PathVariable String version, @PathVariable String extension ) {
        Map<String, Object> values = new HashMap<String, Object>();
        values.put( "name", name );
        values.put( "version", version );
        values.put( "extension", extension );
        
        ModelAndView mv = new ModelAndView();
        mv.addObject( "configs", values );
        mv.setViewName( "config/regular" );
        return mv;
    }
}
