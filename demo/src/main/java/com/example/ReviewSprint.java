package com.example;

import java.util.Date;

import com.example.Pipeline.Pipeline;

public class ReviewSprint extends Sprint {

    public ReviewSprint(String name, Date startDate, Date endDate) {
        super(name, startDate, endDate);
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

    @Override
    public void setPipeline(Pipeline pipeline) {
        System.out.println("Cannot set pipeline for reviewsprint");
    }
}
