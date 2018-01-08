package com.qiaogh.controller;

import com.qiaogh.domain.User;
import com.qiaogh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.*;
import java.net.URLDecoder;

@Controller
public class UserLoginController {

    private UserService userService;

    @ModelAttribute
    public User user() {
        return new User();
    }

    @RequestMapping( value = "/login", method = RequestMethod.GET )
    public String login() {
        return "enroll";
    }

    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public String login( @RequestParam( "portrait" ) MultipartFile portrait, @Valid User user, BindingResult errors, ModelMap modelMap ) throws IOException {
        File file = new File( buildFileName( portrait ) );
        portrait.transferTo( file );
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

    private String buildFileName( MultipartFile portrait ) throws UnsupportedEncodingException {
        String portraitsDir = URLDecoder.decode( UserLoginController.class.getResource( "/portraits" ).toString(), "UTF-8" );
        String originalFilename = portrait.getOriginalFilename();
        return portraitsDir + "/" + originalFilename;
    }

    @Autowired
    public void setUserService( UserService userService ) {
        this.userService = userService;
    }
}
