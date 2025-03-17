package com.example.NotificationLib;

public class SlackNotificationAdapter implements INotificationStrategy {
     
    private SlackNotificationService slackNotificationService;
    
    public SlackNotificationAdapter(SlackNotificationService slackNotificationService) {
        this.slackNotificationService = slackNotificationService;
    }
    
    @Override
    public void sendNotification(String message) {
        slackNotificationService.sendSlackNotification(message);
    }

}
