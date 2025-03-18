package com.example.Pipeline;

public abstract class PipelineStep {
    private String name;
    private boolean successful;

    public void runStep() {
        // Method implementation
    }

    protected void initialize() {
        // Method implementation
    }

    protected void execute() {
        // Method implementation
    }

    protected boolean publishResult() {
        return false;
    }

    public boolean isSuccessful() {
        // Method implementation
        return false;
    }
}