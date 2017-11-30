package com.qiaogh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qiaogh.domain.Person;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {
    
    @RequestMapping( "/simple" )
    public ModelAndView simple( Person person ) {
        ModelAndView mv = new ModelAndView( "config/simple" );
        mv.addObject( person );
        return mv;
    }
}
