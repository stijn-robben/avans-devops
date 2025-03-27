package com.example.BacklogState;

import com.example.BackLogItem;

public class ReadyForTestingState implements IBacklogState {
    private BackLogItem item;

    public ReadyForTestingState(BackLogItem item) {
        this.item = item;
    }

    @Override
    public void startBacklogItem() {
        System.out.println("Cannot start backlog item from ReadyForTestingState");
    }

    @Override
    public void finishImplementingItem() {
        System.out.println("Cannot finish implementing item from ReadyForTestingState");
    }

    @Override
    public void startTestingItem() {
        System.out.println("Backlog item started testing");
        item.setState(item.getTestingState());
    }

    @Override
    public void finishTestingItem() {
        System.out.println("The item is in the ready for testing state");
    }

    @Override
    public void deployItem() {
        System.out.println("Cannot deploy item from ReadyForTestingState");
    }

    @Override
    public void revertToTodo() {
        System.out.println("The item is in the ready for testing state");
    }

    @Override
    public void revertToReadyForTesting() {
        System.out.println("The item is in the ready for testing state");
    }
    
    @Override
    public String toString() {
        return "ReadyForTesting";
    }

}
