package com.qiaogh.event;

import org.springframework.context.ApplicationEvent;

import com.qiaogh.service.UserService;

@SuppressWarnings( "serial" )
public class UserSavedEvent extends ApplicationEvent {

    public UserSavedEvent( UserService userService ) {
        super( userService );
    }
}
