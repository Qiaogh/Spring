package com.qiaogh.event;

import org.springframework.context.ApplicationEvent;

import com.qiaogh.domain.User;
import com.qiaogh.service.UserService;

@SuppressWarnings( "serial" )
public class UserSavedEvent extends ApplicationEvent implements AppEvent<User> {

    private User user;

    public UserSavedEvent( UserService userService, User user ) {
        super( userService );
        this.user = user;
    }

    @Override
    public User get() {
        return user;
    }
}
