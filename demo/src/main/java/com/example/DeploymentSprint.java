package com.example;

import java.util.Date;

public class DeploymentSprint extends Sprint {

    public DeploymentSprint(String name, Date startDate, Date endDate) {
        super(name, startDate, endDate);
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
