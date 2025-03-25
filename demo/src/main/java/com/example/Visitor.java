package com.example;

public abstract class Visitor
{
    public abstract void visitSprint(Sprint sprint);

    public abstract void visitBacklogItem(BackLogItem backLogItem);

    public abstract void visitActivity(Activity activity);

}