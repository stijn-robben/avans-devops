package com.example;

import java.util.Date;
import java.util.List;

import com.example.Pipeline.Pipeline;
import com.example.TeamMember.ScrumMasterMember;
import com.example.TeamMember.TeamMember;

import com.example.SprintState.*;

public abstract class Sprint {
    private CreatedState createdState;
    private InProgressState inProgressState;
    private FinishedState finishedState;
    private CancelledState cancelledState;
    private ReviewingState reviewingState;
    private ReviewedState reviewedState;
    private ReleasingState releasingState;
    private ReleasedState releasedState;
    private ClosedState closedState;

    private String name;
    private Date startDate;
    private Date endDate;
    private List<BackLogItem> backlogItems;
    protected ISprintState state;
    private List<TeamMember> sprintTeam;
    private ScrumMasterMember scrumMaster;
    private Pipeline linkedPipeline;
    private Document reviewDocument;
    //notification 

    public Sprint(String name, Date startDate, Date endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = new CreatedState(this);

        this.inProgressState = new InProgressState(this);
        this.finishedState = new FinishedState(this);
        this.cancelledState = new CancelledState(this);
        this.reviewingState = new ReviewingState(this);
        this.reviewedState = new ReviewedState(this);
        this.releasingState = new ReleasingState(this);
        this.releasedState = new ReleasedState(this);
        this.closedState = new ClosedState(this);

    }

    public void addBacklogItem(BackLogItem item) {
        backlogItems.add(item);
    }

    public void removeBacklogItem(BackLogItem item) {
        backlogItems.remove(item);
    }

    public void addTeamMember(TeamMember member) {
        sprintTeam.add(member);
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

    
    public void startSprintItem() {
        state.startSprintItem();
    }

    public void finishSprintItem() {
        state.timeFinishSprintItem();
    }

    public void setState(ISprintState state) {
        this.state = state;
    }
    
    public CreatedState getCreatedState() {
        return createdState;
    }

    public InProgressState getInProgressState() {
        return inProgressState;
    }

    public FinishedState getFinishedState() {
        return finishedState;
    }

    public CancelledState getCancelledState() {
        return cancelledState;
    }

    public ClosedState getClosedState() {
        return closedState;
    }

    public void reviewSprintItem() {
        state.reviewSprintItem();
    }

    public void finishReviewingSprintItem() {
        state.finishReviewingSprintItem();
    }

    public ReviewingState getReviewingState() {
        return reviewingState;
    }

    public ReviewedState getReviewedState() {
        return reviewedState;
    }

    public void releaseSprintItem() {
        state.releaseSprintItem();
    }

    public void finishReleasingSprintItem() {
        state.finishReleasingSprintItem();
    }

    public ReleasingState getReleasingState() {
        return releasingState;
    }

    public ReleasedState getReleasedState() {
        return releasedState;
    }
}