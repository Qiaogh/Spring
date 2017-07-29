package com.qiaogh.config;

import java.beans.Introspector;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.qiaogh.notifier.ContextClosedEventNotifier;
import com.qiaogh.notifier.ContextRefreshedEventNotifier;
import com.qiaogh.notifier.ContextStartedEventNotifier;
import com.qiaogh.notifier.ContextStoppedEventNotifier;

@Configuration
@Import({
    ContextRefreshedEventNotifier.class,
    ContextStartedEventNotifier.class,
    ContextStoppedEventNotifier.class,
    ContextClosedEventNotifier.class
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
