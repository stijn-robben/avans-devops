package com.example;
public interface IVersionControl {

    public void commit(String message, BackLogItem item);
    public void push();
    public void pull();
    public void merge(String fromBranch, String toBranch);
    public void createBranch(String name);
    
}
