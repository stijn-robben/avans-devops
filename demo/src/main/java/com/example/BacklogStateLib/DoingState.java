package com.example.BacklogStateLib;

import com.example.BackLogItem;

public class DoingState implements IBacklogState {
    private BackLogItem item;
    
    public DoingState(BackLogItem item) {
        this.item = item;
        
    }

    @Override
    public void startBacklogItem() {
        System.out.println("The item is in the doing state");
    }

    @Override
    public void finishImplementingItem() {
        System.out.println("Backlog item finished implementing");
        item.setState(item.getReadyForTestingState());
    }

    @Override
    public void startTestingItem() {
        System.out.println("The item is in the doing state");
    }

    @Override
    public void finishTestingItem() {
        System.out.println("The item is in the doing state");
    }

    @Override
    public void deployItem() {
        System.out.println("The item is in the doing state");
    }

    @Override
    public void revertToTodo() {
        System.out.println("The item is in the doing state");
    }

    @Override
    public void revertToReadyForTesting() {
        System.out.println("The item is in the doing state");
    }
    
    
    
}
