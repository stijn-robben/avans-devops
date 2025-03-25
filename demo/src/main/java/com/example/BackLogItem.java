package com.example;

import java.util.List;

import com.example.BacklogState.DoingState;
import com.example.BacklogState.DoneState;
import com.example.BacklogState.IBacklogState;
import com.example.BacklogState.ReadyForTestingState;
import com.example.BacklogState.TestedState;
import com.example.BacklogState.TestingState;
import com.example.BacklogState.ToDoState;
import com.example.TeamMember.TeamMember;

public class BackLogItem extends Subject {
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

        this.doingState = new DoingState(this);
        this.readyForTestingState = new ReadyForTestingState(this);
        this.testingState = new TestingState(this);
        this.testedState = new TestedState(this);
        this.doneState = new DoneState(this);
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public void assignDeveloper(TeamMember developer) {
        this.assignedDeveloper = developer;
    }

    public void addDiscussionThread(Thread thread) {
        threads.add(thread);
    }

    public void startBacklogItem() {
        state.startBacklogItem();
    }

    public void finishImplementingItem() {
        state.finishImplementingItem();
        notifyObservers("Backlog item " + title + " is ready for testing");
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