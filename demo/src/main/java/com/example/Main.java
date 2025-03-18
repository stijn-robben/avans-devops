package com.example;

import com.example.BackLogItem;
import com.example.BacklogState.IBacklogState;
import com.example.BacklogState.ToDoState;
import com.example.Notification.NotificationManager;
import com.example.Notification.SlackNotificationAdapter;
import com.example.Notification.SlackNotificationService;
import com.example.TeamMember.TesterMember;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //Notification manager sends notification using SlackNotificationAdapter
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
    }
}