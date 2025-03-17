package com.example.NotificationLib;

public class NotificationManager {
    
    private INotificationStrategy notificationStrategy;
    
    public NotificationManager(INotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }
    
    public void sendNotification(String message) {
        notificationStrategy.sendNotification(message);
    }

}
