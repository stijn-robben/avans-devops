package com.example;

public class GitAdapter implements IVersionControl {
    GitService gitService = new GitService();

    @Override
    public void commit(String message, BackLogItem item) {
        gitService.commit(message, item);   
    }

    @Override
    public void push() {
        gitService.push();
    }

    @Override
    public void pull() {
        gitService.pull();
    }

    @Override
    public void merge(String fromBranch, String toBranch) {
        gitService.merge(fromBranch, toBranch);
    }

    @Override
    public void createBranch(String name) {
        gitService.createBranch(name);
    }
    
}
