package com.qiaogh.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.qiaogh.domain.User;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/user" )
public class UserManageController {

    @InitBinder
    public void initBinder( WebDataBinder binder ) {
        binder.addCustomFormatter( new DateFormatter( "yyyy-MM-dd" ) );
    }

    @RequestMapping( "/jacksonWithoutPassword" )
    @JsonView( User.WithoutPassword.class )
    public User jacksonWithoutPassword( User user ) {
        return user;
    }

    @RequestMapping( "/jacksonAll" )
    @JsonView( User.All.class )
    public User jacksonAll( User user ) {
        return user;
    }
}
