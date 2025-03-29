package com.example.SprintState;

import com.example.Sprint;

public class FinishedState implements ISprintState {
    private Sprint item;

    public FinishedState(Sprint item) {
        this.item = item;
    }

    @Override
    public void startSprintItem() {
        System.out.println("Sprint is in finished state, cannot start sprint");
    }

    @Override
    public void timeFinishSprintItem() {
        System.out.println("Sprint is in finished state, cannot finish sprint");
    }

    @Override
    public void releaseSprintItem() {
        System.out.println("Sprint release has been started");
        item.getLinkedPipeline().runAllSteps();
        item.setState(item.getReleasingState());
    }

    @Override
    public void finishReleasingSprintItem() {
        System.out.println("Sprint is in finished state, cannot finish releasing sprint");
    }

    @Override
    public void reviewSprintItem() {
        System.out.println("Sprint review has been started");
        item.setState(item.getReviewingState());
    }

    @Override
    public void finishReviewingSprintItem() {
        System.out.println("Sprint is in finished state, cannot finish reviewing sprint");
    }

    @Override
    public void closeSprintItem() {
        System.out.println("Sprint is in finished state, cannot close sprint"); 
    }

    @Override
    public void cancelSprintItem() {
        System.out.println("Sprint has been cancelled");
        item.setState(item.getCancelledState());
    }
    
    @Override
    public String toString() {
        return "Finished";
    }
}
