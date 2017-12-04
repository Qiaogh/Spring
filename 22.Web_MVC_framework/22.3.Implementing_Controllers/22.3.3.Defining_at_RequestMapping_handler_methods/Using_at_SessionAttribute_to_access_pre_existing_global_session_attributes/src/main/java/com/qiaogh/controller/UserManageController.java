package com.qiaogh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.qiaogh.domain.User;

@Controller
@RequestMapping( "/userManage" )
@SessionAttributes( "user" )
public class UserManageController {
    
    @RequestMapping( "/info" )
    public ModelAndView info( @SessionAttribute User user ) {
        ModelAndView mv = new ModelAndView( "userManage/info" );
        mv.addObject( user );
        return mv;
    }
}
