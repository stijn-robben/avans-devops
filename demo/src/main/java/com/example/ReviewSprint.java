package com.example;

import java.util.Date;

import com.example.SprintState.ReviewedState;
import com.example.SprintState.ReviewingState;

public class ReviewSprint extends Sprint {
    private ReviewingState reviewingState;
    private ReviewedState reviewedState;

    public ReviewSprint(String name, Date startDate, Date endDate) {
        super(name, startDate, endDate);
        this.reviewingState = new ReviewingState(this);
        this.reviewedState = new ReviewedState(this);
    }
    //methodes en logica die specifiek is voor review sprints
    @Override
    public void releaseSprintItem() {
        System.out.println("Cannot release reviewsprint");
    }

    @Override
    public void finishReleasingSprintItem() {
        System.out.println("Cannot release reviewsprint");
    } 
}
