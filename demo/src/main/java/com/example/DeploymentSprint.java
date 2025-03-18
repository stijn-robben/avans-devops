package com.example;

import java.util.Date;

import com.example.SprintState.ReleasedState;
import com.example.SprintState.ReleasingState;

public class DeploymentSprint extends Sprint {
    private ReleasingState releasingState;
    private ReleasedState releasedState;
    

    public DeploymentSprint(String name, Date startDate, Date endDate) {
        super(name, startDate, endDate);
        this.releasingState = new ReleasingState(this);
        this.releasedState = new ReleasedState(this);
    }
    //methodes en logica die specifiek is voor deployment sprints
    @Override
    public void reviewSprintItem() {
        System.out.println("Cannot review Deploymentsprint");
    }

    @Override
    public void finishReviewingSprintItem() {
        System.out.println("Cannot review Deploymentsprint");
    } 
}
