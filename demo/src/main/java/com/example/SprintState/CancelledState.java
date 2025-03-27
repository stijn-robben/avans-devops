package com.example.SprintState;

import com.example.Sprint;

public class CancelledState implements ISprintState{

    public CancelledState(Sprint item) {
    }

    @Override
    public void startSprintItem() {
        System.out.println("Sprint is in cancelled state, cannot start sprint");
    }

    @Override
    public void timeFinishSprintItem() {
        System.out.println("Sprint is in cancelled state, cannot finish sprint");
    }

    @Override
    public void releaseSprintItem() {
        System.out.println("Sprint is in cancelled state, cannot release sprint");
    }

    @Override
    public void finishReleasingSprintItem() {
        System.out.println("Sprint is in cancelled state, cannot finish releasing sprint");
    }

    @Override
    public void reviewSprintItem() {
        System.out.println("Sprint is in cancelled state, cannot review sprint");
    }

    @Override
    public void finishReviewingSprintItem() {
        System.out.println("Sprint is in cancelled state, cannot finish reviewing sprint");
    }

    @Override
    public void closeSprintItem() {
        System.out.println("Sprint is in cancelled state, cannot close sprint");
    }

    @Override
    public void cancelSprintItem() {
        System.out.println("Sprint is in cancelled state, cannot cancel sprint");
    }
    
}
