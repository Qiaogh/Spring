package com.qiaogh.controller;

import com.qiaogh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserManageController {

    private UserService userService;

    @RequestMapping( "/user" )
    public String user( @RequestParam String userId, Model model ) {
        model.addAttribute( "user", userService.get( userId ) );
        return "user";
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService( UserService userService ) {
        this.userService = userService;
    }
}
