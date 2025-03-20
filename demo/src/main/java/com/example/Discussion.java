package com.example;

import java.util.List;
import java.util.Date;

public class Discussion {
    String title;
    Date creationDate;
    List<Thread> threads;

    public Discussion(String title) {
        this.title = title;
        this.creationDate = new Date();
    }

    public void addThread(Thread thread) {
        threads.add(thread);
    }

    public void removeThread(Thread thread) {
        threads.remove(thread);
    }

    public void lockAllThreads() {
        for (Thread thread : threads) {
            thread.lockDiscussion();
        }
    }

    public void unlockAllThreads() {
        for (Thread thread : threads) {
            thread.unlockDiscussion();
        }
    }


}
