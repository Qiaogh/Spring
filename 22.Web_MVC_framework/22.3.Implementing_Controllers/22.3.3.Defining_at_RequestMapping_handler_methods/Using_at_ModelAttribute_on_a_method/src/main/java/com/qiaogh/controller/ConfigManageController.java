package com.qiaogh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {

    @ModelAttribute( "name" )
    public String name() {
        return "Qiaogh";
    }
    
    @RequestMapping( "/simple" )
    public ModelAndView simple() {
        ModelAndView mv = new ModelAndView( "config/simple" );
        return mv;
    }
}
