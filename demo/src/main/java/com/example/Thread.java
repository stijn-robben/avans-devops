package com.example;

import java.util.ArrayList;
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
        this.locked = false;
        this.messages = new ArrayList<Message>();
    }

    public String getTitle() {
        return title;
    }

    public Date getCreationDate() {
        return creationDate;
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

    public void printMessages() {
        for (Message message : messages) {
            System.out.println(message.getAuthor().getName() + " said: " + message.getContent());
        }
    }
}