package com.qiaogh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.qiaogh.domain.Person;

@Controller
@RequestMapping( "/config" )
@SessionAttributes( "person" )
public class ConfigManageController {
    
    @RequestMapping( "/session" )
    public ModelAndView session( Person person ) {
        ModelAndView mv = new ModelAndView( "config/session" );
        mv.addObject( person );
        return mv;
    }
}
