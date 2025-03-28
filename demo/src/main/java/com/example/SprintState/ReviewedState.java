package com.example.SprintState;

import com.example.Sprint;

public class ReviewedState implements ISprintState {
    private Sprint item;

    public ReviewedState(Sprint item) {
        this.item = item;
    }

    @Override
    public void startSprintItem() {
        System.out.println("Sprint is in reviewed state, cannot start sprint");
    }

    @Override
    public void timeFinishSprintItem() {
        System.out.println("Sprint is in reviewed state, cannot finish sprint");
    }

    @Override
    public void releaseSprintItem() {
        System.out.println("Sprint is in reviewed state, cannot release sprint");
    }

    @Override
    public void finishReleasingSprintItem() {
        System.out.println("Sprint is in reviewed state, cannot finish releasing sprint");
    }

    @Override
    public void reviewSprintItem() {
        System.out.println("Sprint is in reviewed state, cannot review sprint");
    }

    @Override
    public void finishReviewingSprintItem() {
        System.out.println("Sprint is in reviewed state, cannot finish reviewing sprint");
    }

    @Override
    public void closeSprintItem() {
        System.out.println("Sprint has been closed");
        item.setState(item.getClosedState());
    }

    @Override
    public void cancelSprintItem() {
        System.out.println("Sprint is in reviewed state, cannot cancel sprint");
    }
    
    @Override
    public String toString() {
        return "Reviewed";
    }
}
