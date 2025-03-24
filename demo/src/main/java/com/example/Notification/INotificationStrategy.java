package com.example.Notification;

import com.example.Observer;

public interface INotificationStrategy extends Observer {
    
    public void sendNotification(String message);

}
