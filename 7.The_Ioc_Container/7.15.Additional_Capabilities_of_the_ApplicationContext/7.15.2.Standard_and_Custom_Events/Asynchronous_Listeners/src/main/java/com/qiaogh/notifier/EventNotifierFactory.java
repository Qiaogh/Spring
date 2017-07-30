package com.qiaogh.notifier;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.qiaogh.config.AppConfig;
import com.qiaogh.event.UserSavedEvent;
import com.qiaogh.event.UserUpdatedEvent;

@Component
public class EventNotifierFactory {

    @Async
    @EventListener({
        ContextStartedEvent.class,
        ContextRefreshedEvent.class,
        ContextStoppedEvent.class,
        ContextClosedEvent.class
    })
    public void handleContextStart( ApplicationEvent event ) {
        String eventName = AppConfig.getEventName( event );
        AppConfig.put( eventName, event );
    }

    @Async
    @EventListener( value = {
        UserSavedEvent.class,
        UserUpdatedEvent.class
    }, condition = "#event.user.sex == '男'" )
    public void handleUserEvent( ApplicationEvent event ) {
        String eventName = AppConfig.getEventName( event );
        AppConfig.put( eventName, event );
    }
}
