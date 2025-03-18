package com.example.Pipeline;

public class PackageStep extends PipelineStep {
    boolean result = false;

    @Override
    public void runStep() {
        System.out.println("Running Package Step");
        execute();
    }

    @Override
    public void initialize() {
        System.out.println("Initializing Package Step");
    }

    @Override
    public void execute() {
        System.out.println("Executing Package Step");
        try {
            System.out.println("Execution succesful");
            result = true;
        } catch (Exception e) {
            System.out.println("Error during Package Step: " + e.getMessage());
            result = false;
        }
        System.out.println("------------------------------");
    }

    @Override
    public boolean publishResult() {
        return result;
    }

}
