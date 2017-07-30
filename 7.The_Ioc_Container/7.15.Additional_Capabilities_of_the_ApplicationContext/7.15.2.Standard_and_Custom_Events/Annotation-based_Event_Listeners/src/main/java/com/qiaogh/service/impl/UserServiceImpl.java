package com.qiaogh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.qiaogh.domain.User;
import com.qiaogh.event.UserSavedEvent;
import com.qiaogh.event.UserUpdatedEvent;
import com.qiaogh.service.UserService;

@Component( "userService" )
public class UserServiceImpl implements UserService {

    private ApplicationEventPublisher publisher;
    
    @Override
    public void save( User user ) {
        publisher.publishEvent( new UserSavedEvent( this, user ) );
    }
    
    @Override
    public void update( User user ) {
        publisher.publishEvent( new UserUpdatedEvent( this, user ) );
    }

    public ApplicationEventPublisher getPublisher() {
        return publisher;
    }

    @Autowired
    public void setPublisher( ApplicationEventPublisher publisher ) {
        this.publisher = publisher;
    }
}
