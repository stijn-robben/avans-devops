package com.example;

import java.util.Date;
import java.util.List;

public class Thread {
    private String title;
    private Date creationDate;
    private List<Message> messages;
    private boolean locked;
    private BackLogItem backlogItem;

    public void addMessage(Message message) {
        // Method implementation
    }

    public void lockDiscussion() {
        // Method implementation
    }

    public void unlockDiscussion() {
        // Method implementation
    }
}