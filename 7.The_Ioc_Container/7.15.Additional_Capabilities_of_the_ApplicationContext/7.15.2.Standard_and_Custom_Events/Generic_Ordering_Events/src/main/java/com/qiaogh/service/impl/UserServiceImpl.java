package com.qiaogh.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.qiaogh.domain.User;
import com.qiaogh.event.UserSavedEvent;
import com.qiaogh.service.UserService;

@SuppressWarnings( "serial" )
@Component( "userService" )
public class UserServiceImpl extends ArrayList<User> implements UserService {

    private ApplicationEventPublisher publisher;
    
    @Override
    public void save( User user ) {
        this.add( user );
        publisher.publishEvent( new UserSavedEvent( this, user ) );
    }
    
    public ApplicationEventPublisher getPublisher() {
        return publisher;
    }

    @Autowired
    public void setPublisher( ApplicationEventPublisher publisher ) {
        this.publisher = publisher;
    }
}
