package com.example;

import com.example.NotificationLib.NotificationManager;
import com.example.NotificationLib.SlackNotificationAdapter;
import com.example.NotificationLib.SlackNotificationService;
import com.example.TeamMemberLib.TesterMember;
import com.example.BacklogStateLib.IBacklogState;
import com.example.BacklogStateLib.ToDoState;
import com.example.BackLogItem;

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