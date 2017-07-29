package com.qiaogh.config;

import java.beans.Introspector;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.qiaogh.notifier.UserSavedEventNotifier;
import com.qiaogh.service.impl.UserServiceImpl;

@Configuration
@Import({
    UserServiceImpl.class,
    UserSavedEventNotifier.class
})
public class AppConfig {

    private static Map<String, ApplicationEvent> events = new HashMap<String, ApplicationEvent>();
    
    public static void put( String eventName, ApplicationEvent event) {
        events.put( eventName, event );
    }
    
    public static String getEventName( ApplicationEvent event ) {
        return Introspector.decapitalize( event.getClass().getSimpleName() );
    }
    
    public static boolean contains( String eventName ) {
        return events.containsKey( eventName );
    }
    
    public static ApplicationEvent get( String eventName ) {
        return events.get( eventName );
    }
    
    public static ApplicationEvent remove( String eventName ) {
        return events.remove( eventName );
    }
}
