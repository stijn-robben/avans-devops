package com.example.SprintState;

import com.example.Sprint;

public class CreatedState implements ISprintState {
    private Sprint item;

    public CreatedState(Sprint item) {
        this.item = item;
    }

    @Override
    public void startSprintItem() {
        System.out.println("Sprint started");
        item.setState(item.getInProgressState());
    }

    @Override
    public void timeFinishSprintItem() {
        System.out.println("Sprint is in created state, cannot finish sprint");
    }

    @Override
    public void releaseSprintItem() {
        System.out.println("Sprint is in created state, cannot release sprint");
    }

    @Override
    public void finishReleasingSprintItem() {
        System.out.println("Sprint is in created state, cannot finish releasing sprint");
    }

    @Override
    public void reviewSprintItem() {
        System.out.println("Sprint is in created state, cannot review sprint");
    }

    @Override
    public void finishReviewingSprintItem() {
        System.out.println("Sprint is in created state, cannot finish reviewing sprint");
    }

    @Override
    public void closeSprintItem() {
        System.out.println("Sprint is in created state, cannot close sprint");
    }

    @Override
    public void cancelSprintItem() {
        System.out.println("Sprint is in created state, cannot cancel sprint");
    }
    
    @Override
    public String toString() {
        return "Created";
    }
}
