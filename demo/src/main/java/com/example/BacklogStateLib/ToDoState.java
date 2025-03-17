package com.example.BacklogStateLib;

import com.example.BackLogItem;

public class ToDoState implements IBacklogState {
    private BackLogItem item;

    public ToDoState(BackLogItem item) {
        this.item = item;
    }

    @Override
    public void startBacklogItem() {
        System.out.println("Backlog item started implementing");
        item.setState(item.getDoingState());
    }

    @Override
    public void finishImplementingItem() {
        System.out.println("The item is still in the to do state");
    }

    @Override
    public void startTestingItem() {
        System.out.println("The item is still in the to do state");
    }

    @Override
    public void finishTestingItem() {
        System.out.println("The item is still in the to do state");
    }

    @Override
    public void deployItem() {
        System.out.println("The item is still in the to do state");
    }

    @Override
    public void revertToTodo() {
        System.out.println("The item is still in the to do state");
    }

    @Override
    public void revertToReadyForTesting() {
        System.out.println("The item is still in the to do state");
    }
    
}
