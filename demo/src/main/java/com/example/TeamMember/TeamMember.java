package com.example.TeamMember;

public abstract class TeamMember {
    private String name;

    public TeamMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
