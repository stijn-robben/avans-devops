package com.example;

import java.util.List;

import com.example.TeamMember.ProductOwnerMember;
import com.example.TeamMember.TeamMember;


public class Project {
    private String name;
    private List<TeamMember> teamMembers;
    private List<Sprint> sprints;
    private ProductOwnerMember productOwner;
    private IVersionControl versionControl;
    private Forum forum;

    public Project(String name, ProductOwnerMember productOwner) {
        this.name = name;
        this.productOwner = productOwner;
        forum = new Forum("Forum");
        //versionControl = new GitVersionControl();
    }


    public void addSprint(Sprint sprint) {
        sprints.add(sprint);
    }

    public void addTeamMember(TeamMember teamMember) {
        teamMembers.add(teamMember);
    }

    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public void setProductOwner(ProductOwnerMember owner) {
        this.productOwner = owner; 
    }
}