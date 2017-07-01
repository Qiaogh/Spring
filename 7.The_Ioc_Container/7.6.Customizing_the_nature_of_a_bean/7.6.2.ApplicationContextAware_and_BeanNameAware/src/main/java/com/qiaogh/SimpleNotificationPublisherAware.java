package com.qiaogh;

import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class SimpleNotificationPublisherAware implements NotificationPublisherAware {

    private NotificationPublisher notificationPublisher;
    
    @Override
    public void setNotificationPublisher( NotificationPublisher notificationPublisher ) {
        this.notificationPublisher = notificationPublisher;
    }
    
    public NotificationPublisher getNotificationPublisher() {
        return notificationPublisher;
    }
}
