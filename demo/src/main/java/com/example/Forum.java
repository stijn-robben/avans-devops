package com.example;

import java.util.Date;
import java.util.List;

public class Forum {
    String title;
    List<Discussion> discussions;
    Date creationDate = new Date();

    public Forum(String title) {
        this.title = title;
        creationDate = new Date();
    }

    public void addDiscussion(Discussion discussion) {
        discussions.add(discussion);
    }

    public void removeDiscussion(Discussion discussion) {
        discussions.remove(discussion);
    }

}
