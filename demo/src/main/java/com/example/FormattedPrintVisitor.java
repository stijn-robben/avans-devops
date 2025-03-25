package com.example;

public class FormattedPrintVisitor extends Visitor {

    private int indentLevel = 0;

    private String indent() {
        return "    ".repeat(indentLevel); // 4 spaces per level
    }

    public FormattedPrintVisitor() {
    }

    @Override
    public void visitSprint(Sprint sprint) {
        String border = "=".repeat(sprint.getName().length() + 18);
        System.out.println("\n" + border);
        System.out.println("     ~~~ " + sprint.getName() + " ~~~");
        System.out.println(border + "\n");

        // Increase indent for contents of the sprint
        indentLevel = 1;
    }

    @Override
    public void visitBacklogItem(BackLogItem backLogItem) {
        // Reset to consistent level for all backlog items
        indentLevel = 1;
        System.out.println(indent() + backLogItem.getTitle() + " [" + backLogItem.getAssignedDeveloperName() + "]");
        System.out.println(indent() + "-".repeat(backLogItem.getTitle().length() + backLogItem.getAssignedDeveloperName().length() + 5));

        // Increase indent for activities
        indentLevel = 2;
    }

    @Override
    public void visitActivity(Activity activity) {
        System.out.println(indent() + "* " + activity.getTitle() + " (" + activity.getTotalEstimatedHours() + " hours)"
                + (activity.isDone() ? " - Done" : "")
                + " - " + activity.getAssignedDeveloper().getName());
    }
}
