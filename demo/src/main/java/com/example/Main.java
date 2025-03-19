package com.example;

import com.example.BackLogItem;
import com.example.BacklogState.IBacklogState;
import com.example.BacklogState.ToDoState;
import com.example.Notification.INotificationStrategy;
import com.example.Notification.NotificationManager;
import com.example.Notification.SlackNotificationAdapter;
import com.example.Notification.SlackNotificationService;
import com.example.Pipeline.Pipeline;
import com.example.TeamMember.TesterMember;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SlackNotificationService slackNotificationService = new SlackNotificationService();
        NotificationManager notificationManager = new NotificationManager(new SlackNotificationAdapter(slackNotificationService));
        notificationManager.sendNotification("Hello from Slack!");

        //Member works
        TesterMember tester = new TesterMember("John Doe");
        tester.getName();

        //Backlog state works
        BackLogItem backlogItem = new BackLogItem("Implement feature X");
        backlogItem.startBacklogItem();
        backlogItem.finishTestingItem();

        
        
        Pipeline pipeline = new Pipeline("CI/CD Pipeline");
        pipeline.runAllSteps();


    }
}