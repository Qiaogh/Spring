package com.qiaogh.controller;

import com.qiaogh.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {
    
    @RequestMapping( "/put" )
    public ModelAndView put( Person person ) {
        ModelAndView mv = new ModelAndView( "config/put" );
        mv.addObject( person );
        return mv;
    }
}
