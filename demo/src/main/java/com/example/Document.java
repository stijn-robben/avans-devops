package com.example;

import java.util.Date;

public class Document {
    private String filename;
    private String content;
    private Date uploadDate;

    public Document(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.uploadDate = new Date();
    }

    public String getContent() {
        return content;
    }

    public String getFileName() {
        return filename;
    }

    public Date getUploadDate() {
        return uploadDate;
    }
}