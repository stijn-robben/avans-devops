package com.example;

import java.util.Date;

import com.example.TeamMember.TeamMember;

public class Message {
    private String content;
    private TeamMember author;
    private Date timestamp;
    private Thread thread;

    public Message(String content, TeamMember author, Thread thread) {
        this.content = content;
        this.author = author;
        this.timestamp = new Date();
        this.thread = thread;
    }

    public String getContent() {
        return content;
    }

    public TeamMember getAuthor() {
        return author;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public BackLogItem getBacklogItem() {
        return thread.getBacklogItem();
    }

    public Thread getThreadItem() {
        return thread;  
    }
}   