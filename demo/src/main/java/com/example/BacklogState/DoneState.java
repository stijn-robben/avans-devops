package com.example.BacklogState;

import com.example.BackLogItem;

public class DoneState implements IBacklogState {
    private BackLogItem item;
    
    public DoneState(BackLogItem item) {
        this.item = item;
        
    }
    
    @Override
    public void startBacklogItem() {
        System.out.println("Cannot start a backlog item that is already done.");
    }
    
    @Override
    public void finishImplementingItem() {
        System.out.println("Cannot finish implementing a backlog item that is already done.");
    }
    
    @Override
    public void startTestingItem() {
        System.out.println("Cannot start testing a backlog item that is already done.");
    }
    
    @Override
    public void finishTestingItem() {
        System.out.println("Cannot finish testing a backlog item that is already done.");
    }
    
    @Override
    public void deployItem() {
        System.out.println("Cannot deploy a backlog item that is already done.");
    }

    @Override
    public void revertToTodo() {
        System.out.println("The item is in the done state.");
    }

    @Override
    public void revertToReadyForTesting() {
        System.out.println("The item is in the done state.");
    }

}
