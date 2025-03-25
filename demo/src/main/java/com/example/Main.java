package com.example;

import java.util.Date;

import com.example.BackLogItem;
import com.example.BacklogState.IBacklogState;
import com.example.BacklogState.ToDoState;
import com.example.Notification.NotificationManager;
import com.example.Notification.SlackNotificationAdapter;
import com.example.Notification.SlackNotificationService;
import com.example.Pipeline.Pipeline;
import com.example.TeamMember.DeveloperMember;
import com.example.TeamMember.TesterMember;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SlackNotificationService slackNotificationService = new SlackNotificationService();
        NotificationManager notificationManager = new NotificationManager(new SlackNotificationAdapter(slackNotificationService));
        notificationManager.sendNotification("Hello from Slack!");

        //Member works
        TesterMember tester = new TesterMember("John Doe");
        System.out.println(tester.getName());

        //Backlog state works
        BackLogItem backlogItem = new BackLogItem("Implement feature X");
        backlogItem.addObserver(notificationManager);
        backlogItem.startBacklogItem();
        backlogItem.finishImplementingItem();

        
        
        Pipeline pipeline = new Pipeline("CI/CD Pipeline");
        pipeline.addObserver(notificationManager);
        pipeline.runAllSteps();


        //Sprint state works
        DeploymentSprint sprint = new DeploymentSprint("Sprint 1", null, null);
        sprint.startSprintItem();
        sprint.finishSprintItem();
        sprint.reviewSprintItem();



                DeveloperMember dev1 = new DeveloperMember("Alice");
        DeveloperMember dev2 = new DeveloperMember("Bob");
        TesterMember tester2 = new TesterMember("John Doe");

        // Create activities
        Activity activity1 = new Activity("Design database schema", 5, dev1);
        Activity activity2 = new Activity("Implement REST API", 8, dev2);
        Activity activity3 = new Activity("Write unit tests", 3, dev1);

        // Create backlog item and assign activities
        BackLogItem backlogItem2 = new BackLogItem("Implement Login/Register feature");
        backlogItem2.assignDeveloper(dev1);
        backlogItem2.addComponent(activity1);
        backlogItem2.addComponent(activity2);
        backlogItem2.addComponent(activity3);


        Activity activity4 = new Activity("Interview stakeholders", 2, dev1);
        Activity activity5 = new Activity("Make architecture", 8, dev2);
        Activity activity6 = new Activity("Programming the new feature", 3, dev1);

        BackLogItem backlogItem3 = new BackLogItem("Implement suggestion feature");
        backlogItem3.assignDeveloper(dev2);
        backlogItem3.addComponent(activity4);
        backlogItem3.addComponent(activity5);
        backlogItem3.addComponent(activity6);

        // Create a sprint and add the backlog item
        DeploymentSprint sprint1 = new DeploymentSprint("Sprint 1", new Date(), new Date());
        sprint1.addComponent(backlogItem2);
        sprint1.addComponent(backlogItem3);
        // Create the visitor and use it
        FormattedPrintVisitor printVisitor = new FormattedPrintVisitor();
        sprint1.acceptVisitor(printVisitor);
        

    }
}