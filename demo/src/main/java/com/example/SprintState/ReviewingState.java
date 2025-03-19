package com.example.SprintState;

import com.example.Sprint;

public class ReviewingState implements ISprintState {
    private Sprint item;

    public ReviewingState(Sprint item) {
        this.item = item;
    }

    @Override
    public void startSprintItem() {
        System.out.println("Sprint is in reviewing state, cannot start sprint");
    }

    @Override
    public void timeFinishSprintItem() {
        System.out.println("Sprint is in reviewing state, cannot finish sprint");
    }

    @Override
    public void releaseSprintItem() {
        System.out.println("Sprint is in reviewing state, cannot release sprint");
    }

    @Override
    public void finishReleasingSprintItem() {
        System.out.println("Sprint is in reviewing state, cannot finish releasing sprint");
    }

    @Override
    public void reviewSprintItem() {
        System.out.println("Sprint is in reviewing state, cannot review sprint");
    }

    @Override
    public void finishReviewingSprintItem() {
        System.out.println("Sprint has been reviewed");
        item.setState(item.getReviewedState());
    }

    @Override
    public void closeSprintItem() {
        System.out.println("Sprint is in reviewing state, cannot close sprint");
    }

    @Override
    public void cancelSprintItem() {
        System.out.println("Sprint has been cancelled");
        item.setState(item.getCancelledState());
    }
    
}
