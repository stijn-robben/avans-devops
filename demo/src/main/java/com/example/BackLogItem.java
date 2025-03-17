package com.example;

import java.util.List;

import com.example.BacklogStateLib.DoingState;
import com.example.BacklogStateLib.DoneState;
import com.example.BacklogStateLib.IBacklogState;
import com.example.BacklogStateLib.ReadyForTestingState;
import com.example.BacklogStateLib.TestedState;
import com.example.BacklogStateLib.TestingState;
import com.example.BacklogStateLib.ToDoState;

public class BackLogItem {
    private ToDoState toDoState;
    private DoingState doingState;
    private ReadyForTestingState readyForTestingState;
    private TestingState testingState;
    private TestedState testedState;
    private DoneState doneState;

    private String title;
    private IBacklogState state;
    private TeamMember assignedDeveloper;
    private List<Thread> threads;
    private List<Activity> activities;

    public BackLogItem(String title) {
        this.title = title;
        this.state = new ToDoState(this);
    }

    public void addActivity(Activity activity) {
        // Method implementation
    }

    public void removeActivity(Activity activity) {
        // Method implementation
    }

    public void assignDeveloper(TeamMember developer) {
        // Method implementation
    }

    public void addDiscussionThread(Thread thread) {
        // Method implementation
    }

    public void startBacklogItem() {
        state.startBacklogItem();
    }

    public void finishImplementingItem() {
        state.finishImplementingItem();
    }

    public void startTestingItem() {
        state.startTestingItem();
    }

    public void finishTestingItem() {
        state.finishTestingItem();
    }

    public void deployItem() {
        state.deployItem();
    }

    public void revertToTodo() {
        state.revertToTodo();
    }

    public void revertToReadyForTesting() {
        state.revertToReadyForTesting();
    }

    public void setState(IBacklogState state) {
        this.state = state;
    }

    public ToDoState getToDoState() {
        return toDoState;
    }

    public DoingState getDoingState() {
        return doingState;
    }

    public ReadyForTestingState getReadyForTestingState() {
        return readyForTestingState;
    }

    public TestingState getTestingState() {
        return testingState;
    }

    public TestedState getTestedState() {
        return testedState;
    }

    public DoneState getDoneState() {
        return doneState;
    }
    
    public ToDoState getTodoState() {
        return toDoState;
    }
}