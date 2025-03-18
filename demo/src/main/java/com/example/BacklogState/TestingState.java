package com.example.BacklogState;

import com.example.BackLogItem;

public class TestingState implements IBacklogState{
    private BackLogItem item;
    
    public TestingState(BackLogItem item) {
        this.item = item;
        
    }
    
    @Override
    public void startBacklogItem() {
        System.out.println("Cannot start backlog item from Testing state");
    }

    @Override
    public void finishImplementingItem() {
        System.out.println("Cannot finish implementing item from Testing state");
    }

    @Override
    public void startTestingItem() {
        System.out.println("Item is already in Testing state");
    }

    @Override
    public void finishTestingItem() {
        System.out.println("Backlog item finished testing");
        item.setState(item.getTestedState());
    }

    @Override
    public void deployItem() {
        System.out.println("Cannot deploy item from Testing state");
    }

    @Override
    public void revertToTodo() {
        System.out.println("Reverted item from testing to todo");
        item.setState(item.getTodoState());
    }

    @Override
    public void revertToReadyForTesting() {
        System.out.println("The item is in the testing state");
    }

}
