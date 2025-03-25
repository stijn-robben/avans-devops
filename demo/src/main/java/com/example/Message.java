package com.example;

import java.util.Date;

import com.example.TeamMember.TeamMember;

public class Message {
    private String content;
    private TeamMember author;
    private Date timestamp;

    public Message(String content, TeamMember author) {
        this.content = content;
        this.author = author;
        this.timestamp = new Date();
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
    
}   