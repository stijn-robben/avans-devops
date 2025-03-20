package com.example;

public class GitService {

    public void merge(String fromBranch, String toBranch) {
        System.out.println("Merging branch " + fromBranch + " into branch " + toBranch);
    }

    public void createBranch(String name) {
        System.out.println("Creating branch " + name);
    }

    public void pull() {
        System.out.println("Pulling changes from remote repository");
    }

    public void push() {
        System.out.println("Pushing changes to remote repository");
    }

    public void commit(String message, BackLogItem item) {
        System.out.println("Committing changes " + item + " with message: " + message);
    }

}
