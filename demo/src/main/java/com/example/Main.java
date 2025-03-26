package com.example;

import java.util.Date;

import com.example.BackLogItem;
import com.example.BacklogState.ToDoState;
import com.example.Notification.NotificationManager;
import com.example.Notification.SlackNotificationAdapter;
import com.example.Notification.SlackNotificationService;
import com.example.Pipeline.Pipeline;
import com.example.TeamMember.DeveloperMember;
import com.example.TeamMember.TesterMember;

public class Main {
    public static void main(String[] args) {
        // Start the system test
        System.out.println("=== Project System Test ===\n");

        // 1. Test: Slack Notification System
        testSlackNotificationSystem();

        // 2. Test: Team Member Creation
        testTeamMember();

        // 3. Test: Backlog Item State and Observer
        testBacklogItemState();

        // 4. Test: CI/CD Pipeline
        testPipeline();

        // 5. Test: Sprint Workflow
        testSprintWorkflow();

        // 6. Test: Team Activities and Backlog Items
        testTeamActivitiesAndBacklogItems();

        // 7. Test: Version Control System (Git Adapter)
        testVersionControlSystem();
        
        System.out.println("\n=== All Tests Completed Successfully! ===");
    }

    // Slack Notification System Test
    private static void testSlackNotificationSystem() {
        System.out.println("=== Testing Slack Notification System ===");
        SlackNotificationService slackNotificationService = new SlackNotificationService();
        NotificationManager notificationManager = new NotificationManager(new SlackNotificationAdapter(slackNotificationService));
        notificationManager.sendNotification("Hello from Slack Notification Manager!");
        System.out.println("Slack notification sent successfully!\n");
    }

    // Team Member Creation Test
    private static void testTeamMember() {
        System.out.println("=== Testing Team Member Creation ===");
        TesterMember tester = new TesterMember("John Doe");
        System.out.println("Tester created: " + tester.getName() + "\n");
    }

    // Backlog Item State and Observer Test
    private static void testBacklogItemState() {
        System.out.println("=== Testing Backlog Item State and Observer ===");
        BackLogItem backlogItem = new BackLogItem("Implement feature X");
        backlogItem.addObserver(new NotificationManager(new SlackNotificationAdapter(new SlackNotificationService())));
        
        backlogItem.startBacklogItem();
        backlogItem.finishImplementingItem();
        System.out.println("Backlog item state transitions completed!\n");
    }

    // CI/CD Pipeline Test
    private static void testPipeline() {
        System.out.println("=== Testing CI/CD Pipeline ===");
        Pipeline pipeline = new Pipeline("CI/CD Pipeline");
        pipeline.addObserver(new NotificationManager(new SlackNotificationAdapter(new SlackNotificationService())));
        pipeline.runAllSteps();
        System.out.println("Pipeline steps executed successfully!\n");
    }

    // Sprint Workflow Test
    private static void testSprintWorkflow() {
        System.out.println("=== Testing Sprint Workflow ===");
        DeploymentSprint sprint = new DeploymentSprint("Sprint 1", null, null);
        sprint.startSprintItem();
        sprint.finishSprintItem();
        sprint.reviewSprintItem();
        System.out.println("Sprint workflow completed!\n");
    }

    // Team Activities and Backlog Items Test
    private static void testTeamActivitiesAndBacklogItems() {
        System.out.println("=== Testing Team Activities and Backlog Items ===");

        DeveloperMember dev1 = new DeveloperMember("Alice");
        DeveloperMember dev2 = new DeveloperMember("Bob");

        Activity activity1 = new Activity("Design database schema", 5, dev1);
        Activity activity2 = new Activity("Implement REST API", 8, dev2);
        Activity activity3 = new Activity("Write unit tests", 3, dev1);

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

        DeploymentSprint sprint1 = new DeploymentSprint("Sprint 2", new Date(), new Date());
        sprint1.addComponent(backlogItem2);
        sprint1.addComponent(backlogItem3);

        // Visitor print
        FormattedPrintVisitor printVisitor = new FormattedPrintVisitor();
        sprint1.acceptVisitor(printVisitor);

    }

    // Version Control System Test (Git Adapter)
    private static void testVersionControlSystem() {
        System.out.println("=== Testing Version Control System ===");

        IVersionControl git = new GitAdapter();

        git.createBranch("feature/login");
        git.commit("Initial commit of login feature", new BackLogItem("Implement Login Feature"));
        git.push();
        git.pull();
        git.merge("feature/login", "main");

        System.out.println("Git version control operations completed!\n");
    }
}
