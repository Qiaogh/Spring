package com.qiaogh.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.qiaogh.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping( "/user" )
public class UserController {

    private static Logger LOGGER = LoggerFactory.getLogger( UserController.class );

    @RequestMapping( "/save" )
    @JsonView( User.Json.class )
    public Callable<User> save( final User user ) {
        LOGGER.info( "request begin" );
        Callable<User> callable = new Callable<User>() {
            @Override
            public User call() throws Exception {
                LOGGER.info( "callback ok" );
                return user;
            }
        };
        LOGGER.info( "request end" );
        return callable;
    }
}
