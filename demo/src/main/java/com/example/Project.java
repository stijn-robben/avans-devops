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

    public void addSprint(Sprint sprint) {
        // Method implementation
    }

    public void addTeamMember(TeamMember teamMember) {
        // Method implementation
    }

    public List<TeamMember> getTeamMembers() {
        // Method implementation
        return null;
    }

    public List<Sprint> getSprints() {
        // Method implementation
        return null;
    }

    public void setProductOwner(ProductOwnerMember owner) {
        // Method implementation
    }
}