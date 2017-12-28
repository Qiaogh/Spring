package com.qiaogh.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qiaogh.domain.User;
import com.qiaogh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class UserLoginController {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private UserService userService;

    @RequestMapping( "/login" )
    public Object login( @Valid User user, BindingResult errors, RedirectAttributesModelMap modelMap ) throws JsonProcessingException {
        if ( errors.hasErrors() ) {
            return "enroll";
        }
        User persistUser = userService.getByName( user.getName() );

        if ( persistUser != null && persistUser.getPassword().equals( user.getPassword() ) ) {
            modelMap.addAttribute( "user", OBJECT_MAPPER.writeValueAsString( persistUser ) );
            return "redirect:success";
        }
        return "redirect:error";
    }

    @RequestMapping( "/success" )
    public String success( User user, ModelMap modelMap ) {
        user.setPassword( "" );
        modelMap.addAttribute( "user", user );
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
