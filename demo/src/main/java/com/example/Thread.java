package com.example;

import java.util.Date;
import java.util.List;

public class Thread {
    private String title;
    private Date creationDate;
    private List<Message> messages;
    private boolean locked;
    private BackLogItem backlogItem;

    public Thread(String title, BackLogItem backlogItem) {
        this.title = title;
        this.creationDate = new Date();
        this.backlogItem = backlogItem;
        this.locked=false;
    }

    public void addMessage(Message message) {
        if (locked) {
            System.out.println("Thread is locked, you cannot add a message");
        } else {
            messages.add(message);
        }
    }

    public void lockDiscussion() {
        this.locked = true;
    }

    public void unlockDiscussion() {
        this.locked = false;
    }

    public BackLogItem getBacklogItem(){
        return backlogItem;
    }
}