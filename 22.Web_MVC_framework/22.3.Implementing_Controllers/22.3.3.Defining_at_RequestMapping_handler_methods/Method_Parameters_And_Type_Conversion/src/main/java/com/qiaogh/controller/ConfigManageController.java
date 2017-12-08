package com.qiaogh.controller;

import com.qiaogh.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {

    @RequestMapping( "/typeConvert" )
    public ModelAndView typeConvert( Person person ) {
        ModelAndView mv = new ModelAndView( "config/typeConvert" );
        mv.addObject( person );
        return mv;
    }
}
