package com.qiaogh.controller;

import com.qiaogh.domain.User;
import com.qiaogh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserLoginController {

    private UserService userService;

    @RequestMapping( "/login" )
    public String login( @Valid User user, BindingResult errors, ModelMap modelMap ) {
        if ( errors.hasErrors() ) {
            return "enroll";
        }
        User persistUser = userService.getByName( user.getName() );

        if ( persistUser.getPassword().equals( user.getPassword() ) ) {
            modelMap.addAttribute( "user", persistUser );
            return "success";
        }
        return "error";
    }

    @Autowired
    public void setUserService( UserService userService ) {
        this.userService = userService;
    }
}
