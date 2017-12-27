package com.qiaogh.controller;

import com.qiaogh.domain.User;
import com.qiaogh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserLoginController {

    private UserService userService;

    @RequestMapping( "/login" )
    public Object login( @Valid User user, BindingResult errors, HttpSession session ) {
        if ( errors.hasErrors() ) {
            return "enroll";
        }
        User persistUser = userService.getByName( user.getName() );

        if ( persistUser != null && persistUser.getPassword().equals( user.getPassword() ) ) {

            session.setAttribute( "user", persistUser );
            return new RedirectView( "/success" );
        }
        return new RedirectView( "/error" );
    }

    @RequestMapping( "/success" )
    public String success() {
        return "success";
    }

    @RequestMapping( "/error" )
    public String error( @ModelAttribute User user ) {
        return "error";
    }

    @Autowired
    public void setUserService( UserService userService ) {
        this.userService = userService;
    }
}
