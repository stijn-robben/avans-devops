package com.example.Pipeline;

public class AnalyzeStep extends PipelineStep {
    boolean result = false;

    @Override
    public void runStep() {
        System.out.println("Running Analyze Step");
        execute();

    }

    @Override
    public void initialize() {
        System.out.println("Initializing Analyze Step");
    }

    @Override
    public void execute() {
        System.out.println("Executing Analyze Step");
        try {
            System.out.println("Execution succesful");
            result = true;
        } catch (Exception e) {
            System.out.println("Error during Analyze Step: " + e.getMessage());
            result = false;
        }
        System.out.println("------------------------------");

    }

    @Override
    public boolean publishResult() {
        return result;
    }

}
