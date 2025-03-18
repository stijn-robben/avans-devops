package com.example;

import com.example.Notification.NotificationManager;
import com.example.Notification.SlackNotificationAdapter;
import com.example.Notification.SlackNotificationService;
import com.example.Pipeline.Pipeline;
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
        System.out.println(tester.getName());

        //Backlog state works
        BackLogItem backlogItem = new BackLogItem("Implement feature X");
        backlogItem.startBacklogItem();
        backlogItem.finishTestingItem();

        
        
        Pipeline pipeline = new Pipeline("CI/CD Pipeline");

        // Run all steps in the pipeline
        pipeline.runAllSteps();


        //Sprint state works
        DeploymentSprint sprint = new DeploymentSprint("Sprint 1", null, null);
        sprint.startSprintItem();
        sprint.finishSprintItem();
        sprint.reviewSprintItem();
    }
}