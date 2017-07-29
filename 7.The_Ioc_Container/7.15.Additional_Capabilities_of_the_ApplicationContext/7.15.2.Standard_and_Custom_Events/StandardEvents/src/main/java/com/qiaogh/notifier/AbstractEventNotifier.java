package com.qiaogh.notifier;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import com.qiaogh.config.AppConfig;

public class AbstractEventNotifier<T extends ApplicationEvent> implements ApplicationListener<T> {

    @Override
    public void onApplicationEvent( T event ) {
        String eventName = AppConfig.getEventName( event );
        AppConfig.put( eventName, event );
    }
}
