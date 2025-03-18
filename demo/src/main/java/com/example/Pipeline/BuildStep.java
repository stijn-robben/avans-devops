package com.example.Pipeline;

public class BuildStep extends PipelineStep {
    boolean result = false;

    @Override
    public void runStep() {
        System.out.println("Running Build Step");
        execute();

    }

    @Override
    public void initialize() {
        System.out.println("Initializing Build Step");
    }

    @Override
    public void execute() {
        System.out.println("Executing Build Step");
        try {
            System.out.println("Execution succesful");
            result = true;
        } catch (Exception e) {
            System.out.println("Error during Build Step: " + e.getMessage());
            result = false;
        }
        System.out.println("------------------------------");
    }

    @Override
    public boolean publishResult() {
        return false;
    }

}
