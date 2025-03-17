package com.example;

import java.util.Date;
import java.util.List;

public abstract class Sprint {
    private String name;
    private Date startDate;
    private Date endDate;
    private List<BackLogItem> backlogItems;
    private SprintState state;
    private List<TeamMember> sprintTeam;
    private ScrumMasterMember scrumMaster;
    private Pipeline linkedPipeline;
    private Document reviewDocument;

    public void addBacklogItem(BackLogItem item) {
        // Method implementation
    }

    public void removeBacklogItem(BackLogItem item) {
        // Method implementation
    }

    public void addTeamMember(TeamMember member) {
        // Method implementation
    }

    public void start() {
        // Method implementation
    }

    public void finish() {
        // Method implementation
    }


    public void setScrumMaster(ScrumMasterMember master) {
        // Method implementation
    }

    public void setPipeline(Pipeline pipeline) {
        // Method implementation
    }

    public void cancelRelease() {
        // Method implementation
    }

    public void retry() {
        // Method implementation
    }
}