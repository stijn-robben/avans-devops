package com.example;

import java.util.Date;
import java.util.List;

import com.example.Pipeline.Pipeline;
import com.example.TeamMember.ScrumMasterMember;
import com.example.TeamMember.TeamMember;

import com.example.SprintState.*;

public abstract class Sprint extends CompositeComponent{
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
    private final Subject subject = new Subject() {};

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

    // Observer methods delegated to Subject instance
    public void addObserver(Observer observer) {
        subject.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        subject.removeObserver(observer);
    }

    public void notifyObservers(String message) {
        subject.notifyObservers(message);
    }

    public void setStartDate(Date startDate) {
        if (state == createdState) {
            this.startDate = startDate;
        } else {
            System.out.println("Cannot change start date of sprint when it is not in created state");
        }
    }

    public void setEndDate(Date endDate) {
        if (state == createdState) {
            this.endDate = endDate;
        } else {
            System.out.println("Cannot change end date of sprint when it is not in created state");
        }
    }

    public void setName (String name) {
        if (state == createdState) {
            this.name = name;
        } else {
            System.out.println("Cannot change name of sprint when it is not in created state");
        }
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public ScrumMasterMember getScrumMaster() {
        return scrumMaster;
    }

    public Pipeline getLinkedPipeline() {
        return linkedPipeline;
    }

    public Document getReviewDocument() {
        return reviewDocument;
    }

    public void addBacklogItem(BackLogItem item) {
        if (state == createdState) {
            backlogItems.add(item);
        } else {
            System.out.println("Cannot add backlog item to sprint when it is not in created state");
        }
    }

    public void removeBacklogItem(BackLogItem item) {
        if (state == createdState) {
            backlogItems.remove(item);
        } else {
            System.out.println("Cannot remove backlog item from sprint when it is not in created state");
        }
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
        notifyObservers(name + " has been cancelled");
        state.cancelSprintItem();
        
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
        if (reviewDocument != null) {
            state.reviewSprintItem();
        } else {
            System.out.println("Cannot review sprint without a review document");
        }
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
        if (linkedPipeline != null) {
            linkedPipeline.runAllSteps();
            state.releaseSprintItem();
        } else {
            System.out.println("Cannot release sprint without a linked pipeline");
        }
        
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

    public void acceptVisitor(Visitor visitor)
    {
        visitor.visitSprint(this);
        super.acceptVisitor(visitor);
    }

}