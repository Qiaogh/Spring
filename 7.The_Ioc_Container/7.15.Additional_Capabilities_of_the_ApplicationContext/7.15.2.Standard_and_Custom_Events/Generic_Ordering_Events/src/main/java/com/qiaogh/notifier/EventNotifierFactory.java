package com.qiaogh.notifier;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.qiaogh.config.AppConfig;
import com.qiaogh.domain.User;
import com.qiaogh.event.UserSavedEvent;

@Component
public class EventNotifierFactory {

    @Order( 1 )
    @EventListener( value = {
        UserSavedEvent.class
    })
    public void beforeUserSaveEvent( UserSavedEvent event ) {
        User user = event.get();
        Assert.notNull( user, "用户信息不可为空！" );
        Assert.notNull( user.getId(), "用户编号不可为空！" );
    }
    
    @Order( 2 )
    @EventListener( value = {
        UserSavedEvent.class
    })
    public void handleUserSavedEvent( UserSavedEvent event ) {
        String eventName = AppConfig.getEventName( event );
        AppConfig.put( eventName, event );
    }
}
