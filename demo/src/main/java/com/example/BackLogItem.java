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

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
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
        notifyObservers("Backlog item \"" + title + "\" is ready for testing");
    }

    public void startTestingItem() {
        state.startTestingItem();
    }

    public void finishTestingItem() {
        state.finishTestingItem();
    }

    public void deployItem() {
        for (Activity activity : activities) {
            if (activity.isDone()) {
                state.deployItem();

            for (Thread thread : threads) {
                thread.lockDiscussion();
            }
            } else {
                System.out.println("Cannot deploy item, all activities must be completed first");
                return;
            }
        }
    }

    public void revertToTodo() {
        state.revertToTodo();

        for (Thread thread : threads) {
            thread.unlockDiscussion();
        }
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

    public void acceptVisitor(Visitor visitor) {
        visitor.visitBacklogItem(this);
        super.acceptVisitor(visitor);
    }
}
