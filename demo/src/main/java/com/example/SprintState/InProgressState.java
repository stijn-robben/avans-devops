package com.example.SprintState;

import com.example.Sprint;

public class InProgressState implements ISprintState {
    private Sprint item;

    public InProgressState(Sprint item) {
        this.item = item;
    }

    @Override
    public void startSprintItem() {
        System.out.println("Sprint is in progress state, cannot start sprint");
    }

    @Override
    public void timeFinishSprintItem() {
        System.out.println("Sprint has ended");
        item.setState(item.getFinishedState());
    }

    @Override
    public void releaseSprintItem() {
        System.out.println("Sprint is in progress state, cannot release sprint");
    }

    @Override
    public void finishReleasingSprintItem() {
        System.out.println("Sprint is in progress state, cannot finish releasing sprint");
    }

    @Override
    public void reviewSprintItem() {
        System.out.println("Sprint is in progress state, cannot review sprint");
    }

    @Override
    public void finishReviewingSprintItem() {
        System.out.println("Sprint is in progress state, cannot finish reviewing sprint");
    }

    @Override
    public void closeSprintItem() {
        System.out.println("Sprint is in progress state, cannot close sprint");
    }

    @Override
    public void cancelSprintItem() {
        System.out.println("Sprint is in progress state, cannot cancel sprint");
    }
    
    @Override
    public String toString() {
        return "In Progress";
    }
}
