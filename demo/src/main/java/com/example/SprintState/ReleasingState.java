package com.example.SprintState;

import com.example.Sprint;

public class ReleasingState implements ISprintState {
    private Sprint item;

    public ReleasingState(Sprint item) {
        this.item = item;
    }

    @Override
    public void startSprintItem() {
        System.out.println("Sprint is in releasing state, cannot start sprint");
    }

    @Override
    public void timeFinishSprintItem() {
        System.out.println("Sprint is in releasing state, cannot finish sprint");
    }

    @Override
    public void releaseSprintItem() {
        System.out.println("Sprint is in releasing state, cannot release sprint");
    }

    @Override
    public void finishReleasingSprintItem() {
        System.out.println("Sprint has been released");
        item.setState(item.getReleasedState());
    }

    @Override
    public void reviewSprintItem() {
        System.out.println("Sprint is in releasing state, cannot review sprint");
    }

    @Override
    public void finishReviewingSprintItem() {
        System.out.println("Sprint is in releasing state, cannot finish reviewing sprint");
    }

    @Override
    public void closeSprintItem() {
        System.out.println("Sprint is in releasing state, cannot close sprint");
    }

    @Override
    public void cancelSprintItem() {
        System.out.println("Sprint has been cancelled");
        item.setState(item.getCancelledState());
    }
    
    @Override
    public String toString() {
        return "Releasing";
    }
}
