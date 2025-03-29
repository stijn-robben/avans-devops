package com.example.BacklogState;

import com.example.BackLogItem;

public class TestedState implements IBacklogState {
    private BackLogItem item;

    public TestedState(BackLogItem item) {
        this.item = item;
    }

    public void startBacklogItem() {
        System.out.println("Cannot start backlog item. Item is already started.");
    }
    
    public void finishImplementingItem() {
        System.out.println("Cannot finish implementing item. Item is already finished implementing.");
    }
    
    public void startTestingItem() {
        System.out.println("Cannot start testing item. Item is already started testing.");
    }
    
    public void finishTestingItem() {
        
        System.out.println("The item is in the tested state");
    }
    
    public void deployItem() {
        System.out.println("Backlog item finished testing and is now deployed.");
        item.setState(item.getDoneState());
        for (com.example.Thread thread : item.getThreads()) {
            thread.lockDiscussion();
        }
    }

    @Override
    public void revertToTodo() {
        System.out.println("The item is in the tested state");
    }

    @Override
    public void revertToReadyForTesting() {
        System.out.println("Reverted item from tested to ready for testing");
        item.setState(item.getReadyForTestingState());
    }

    @Override
    public String toString() {
        return "Tested";
    }

}
