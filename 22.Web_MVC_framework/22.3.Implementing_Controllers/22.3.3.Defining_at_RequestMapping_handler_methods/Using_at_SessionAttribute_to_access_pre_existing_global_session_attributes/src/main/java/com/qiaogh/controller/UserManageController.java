package com.qiaogh.controller;

import com.qiaogh.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/userManage" )
public class UserManageController {
    
    @RequestMapping( "/info" )
    public ModelAndView info( @SessionAttribute User user ) {
        ModelAndView mv = new ModelAndView( "userManage/info" );
        mv.addObject( user );
        return mv;
    }
}
