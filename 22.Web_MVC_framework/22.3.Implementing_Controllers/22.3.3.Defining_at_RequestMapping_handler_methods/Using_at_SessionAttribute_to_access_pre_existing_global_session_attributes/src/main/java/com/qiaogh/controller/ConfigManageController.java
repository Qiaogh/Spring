package com.qiaogh.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.qiaogh.domain.Person;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {
    
    @RequestMapping( "/session" )
    public ModelAndView session( @SessionAttribute Person person, HttpSession session ) {
        ModelAndView mv = new ModelAndView( "config/session" );
        mv.addObject( person );
        session.getAttribute( "person" );
        return mv;
    }
}
