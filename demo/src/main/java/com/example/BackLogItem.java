package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.BacklogState.DoingState;
import com.example.BacklogState.DoneState;
import com.example.BacklogState.IBacklogState;
import com.example.BacklogState.ReadyForTestingState;
import com.example.BacklogState.TestedState;
import com.example.BacklogState.TestingState;
import com.example.BacklogState.ToDoState;
import com.example.TeamMember.TeamMember;

public class BackLogItem extends CompositeComponent {

    private ToDoState toDoState;
    private DoingState doingState;
    private ReadyForTestingState readyForTestingState;
    private TestingState testingState;
    private TestedState testedState;
    private DoneState doneState;

    private String title;
    private IBacklogState state;
    private TeamMember assignedDeveloper;
    private List<Thread> threads = new ArrayList<>();
    private List<Activity> activities = new ArrayList<>();

    // Composition: Use Subject instance
    private final Subject subject = new Subject() {};

    public BackLogItem(String title) {
        this.title = title;
        this.state = new ToDoState(this);

        this.toDoState = (ToDoState) state;
        this.doingState = new DoingState(this);
        this.readyForTestingState = new ReadyForTestingState(this);
        this.testingState = new TestingState(this);
        this.testedState = new TestedState(this);
        this.doneState = new DoneState(this);

        this.activities = new ArrayList<>();
    }

    // Observer methods delegated to Subject instance
    public void addObserver(Observer observer) {
        subject.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        subject.removeObserver(observer);
    }

    public void notifyObservers(String message) {
        subject.notifyObservers(message);
    }

    public String getAssignedDeveloperName() {
        
        return assignedDeveloper != null ? assignedDeveloper.getName() : "Unassigned";
    }

    public String getTitle() {
        return title;
    }

    public List<Thread> getThreads() {
        return threads;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void assignDeveloper(TeamMember developer) {
        if (assignedDeveloper != null) {
            notifyObservers(assignedDeveloper.getName() + " has been unassigned from " + title);
        }
        notifyObservers(title + " has been assigned to " + developer.getName());
        this.assignedDeveloper = developer;
    }

    public void addDiscussionThread(Thread thread) {
        if (this.state != doneState) {
            threads.add(thread);
        } else {
            System.out.println("Cannot add discussion thread, item is already done");
        }
        
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
        if (!activities.isEmpty()) {
            // Check if all activities are done
            for (Activity activity : activities) {
                if (!activity.isDone()) {
                    System.out.println("Cannot deploy item, all activities must be completed first");
                    return;
                }
            }
            // If all are done, proceed with deployment
            state.deployItem();
        } else {
            state.deployItem();
        }
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

    public IBacklogState getState(){
        return state;
    }

    public void acceptVisitor(Visitor visitor) {
        visitor.visitBacklogItem(this);
        super.acceptVisitor(visitor);
    }
}
