package com.qiaogh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.qiaogh.event.UserSavedEvent;
import com.qiaogh.service.UserService;

@Component( "userService" )
public class UserServiceImpl implements UserService {

    private ApplicationEventPublisher publisher;
    
    @Override
    public void save() {
        ApplicationEvent event = new UserSavedEvent( this );
        publisher.publishEvent( event );
    }

    public ApplicationEventPublisher getPublisher() {
        return publisher;
    }

    @Autowired
    public void setPublisher( ApplicationEventPublisher publisher ) {
        this.publisher = publisher;
    }
}
