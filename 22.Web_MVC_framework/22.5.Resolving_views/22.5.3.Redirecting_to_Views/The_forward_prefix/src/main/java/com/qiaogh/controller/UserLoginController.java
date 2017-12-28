package com.qiaogh.controller;

import com.qiaogh.domain.User;
import com.qiaogh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class UserLoginController {

    private UserService userService;

    @RequestMapping( "/login" )
    public Object login( @Valid User user, BindingResult errors, Model model ) {
        if ( errors.hasErrors() ) {
            return "enroll";
        }
        User persistUser = userService.getByName( user.getName() );

        if ( persistUser != null && persistUser.getPassword().equals( user.getPassword() ) ) {
            model.addAttribute( "persistUser", persistUser );
            return "forward:success";
        }
        return "forward:error";
    }

    @RequestMapping( "/success" )
    public String success( @RequestAttribute( "persistUser" ) User persistUser ) {
        return "success";
    }

    @RequestMapping( "/error" )
    public String error( User user ) {
        return "error";
    }

    @Autowired
    public void setUserService( UserService userService ) {
        this.userService = userService;
    }
}
