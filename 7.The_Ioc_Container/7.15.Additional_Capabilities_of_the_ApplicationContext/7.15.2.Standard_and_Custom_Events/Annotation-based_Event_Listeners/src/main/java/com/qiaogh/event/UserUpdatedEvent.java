package com.qiaogh.event;

import org.springframework.context.ApplicationEvent;

import com.qiaogh.domain.User;
import com.qiaogh.service.UserService;

@SuppressWarnings( "serial" )
public class UserUpdatedEvent extends ApplicationEvent implements UserEvent {

    private User user;
    
    public UserUpdatedEvent( UserService userService, User user ) {
        super( userService );
        this.user = user;
    }

    @Override
    public User getUser() {
        return user;
    }
}
