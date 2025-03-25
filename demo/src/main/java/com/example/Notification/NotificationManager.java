package com.example.Notification;

import com.example.Observer;

public class NotificationManager implements Observer {
    
    private INotificationStrategy notificationStrategy;
    
    public NotificationManager(INotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }
    
    public void sendNotification(String message) {
        notificationStrategy.sendNotification(message);
    }

    @Override
    public void update(String message) {
        this.sendNotification(message);
    }

}
