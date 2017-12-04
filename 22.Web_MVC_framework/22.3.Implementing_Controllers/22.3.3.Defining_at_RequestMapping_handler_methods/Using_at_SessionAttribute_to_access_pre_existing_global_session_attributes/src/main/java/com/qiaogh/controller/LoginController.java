package com.qiaogh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.qiaogh.domain.User;

@Controller
@RequestMapping( "/login" )
@SessionAttributes( "user" )
public class LoginController {

    @ModelAttribute
    public User setUp() {
        return new User();
    }
    
    @RequestMapping( method = RequestMethod.POST )
    public ModelAndView login( User user) {
        return new ModelAndView( "index" );
    }
}
