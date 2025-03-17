package com.example.NotificationLib;

public class EmailNotificationAdapter implements INotificationStrategy{
    
    private EmailNotificationService emailNotificationService;
    
    public EmailNotificationAdapter(EmailNotificationService emailNotificationService) {
        this.emailNotificationService = emailNotificationService;
    }
    
    @Override
    public void sendNotification(String message) {
        emailNotificationService.sendEmail(message);
    }

}
