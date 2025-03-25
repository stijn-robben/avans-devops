package com.example;

import com.example.TeamMember.TeamMember;

public class Activity extends CompositeComponent{
    private String title;
    private boolean done;
    private int estimatedHours;
    private TeamMember assignedDeveloper;

    public Activity(String title, int estimatedHours, TeamMember assignedDeveloper) {
        this.title = title;
        this.done = false;
        this.estimatedHours = estimatedHours;
        this.assignedDeveloper = assignedDeveloper;
    }

    public boolean isDone() {
        return false;
    }

    public TeamMember getAssignedDeveloper() {
        return assignedDeveloper;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getTotalEstimatedHours() {
        return estimatedHours;
    }

    public String getTitle() {
        return title;
    }

    public void acceptVisitor(Visitor visitor)
    {
        visitor.visitActivity(this);
        super.acceptVisitor(visitor);
    }
}