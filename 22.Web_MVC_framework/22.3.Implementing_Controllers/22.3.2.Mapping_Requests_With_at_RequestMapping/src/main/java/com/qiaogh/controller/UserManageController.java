package com.qiaogh.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qiaogh.domain.User;

@Controller
@RequestMapping( "/user" )
public class UserManageController {

    @GetMapping( "/{id}" )
    public ModelAndView view( @PathVariable Integer id, HttpServletRequest request ) {
        User user = new User();
        user.setId( id );
        user.setName( "Qiaogh" );
        
        ModelAndView mv = new ModelAndView();
        mv.addObject( "user", user );
        mv.setViewName( "user/view" );
        return mv;
    }
}
