package com.example;

import java.util.Date;
import java.util.List;

import com.example.Pipeline.Pipeline;
import com.example.TeamMember.ScrumMasterMember;
import com.example.TeamMember.TeamMember;

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
    //notification 

    public void addBacklogItem(BackLogItem item) {
        backlogItems.add(item);
    }

    public void removeBacklogItem(BackLogItem item) {
        backlogItems.remove(item);
    }

    public void addTeamMember(TeamMember member) {
        sprintTeam.add(member);
    }

    public void start() {
        // Method implementation (iets met states)
    }

    public void finish() {
        // Method implementation
    }


    public void setScrumMaster(ScrumMasterMember master) {
        scrumMaster = master;
    }

    public void setPipeline(Pipeline pipeline) {
        linkedPipeline = pipeline;
    }

    public void cancelRelease() {
        // Method implementation
        
    }

    public void retry() {
        // Method implementation
    }
}