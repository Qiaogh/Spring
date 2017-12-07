package com.qiaogh.controller;

import com.qiaogh.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {

    @InitBinder
    public void initBinder( WebDataBinder dataBinder ) {
        System.out.println( dataBinder );
    }

    @RequestMapping( "/typeConvert" )
    public ModelAndView typeConvert( Person person ) {
        ModelAndView mv = new ModelAndView( "config/typeConvert" );
        mv.addObject( person );
        return mv;
    }
}
