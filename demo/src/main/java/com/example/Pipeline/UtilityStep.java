package com.example.Pipeline;

public class UtilityStep extends PipelineStep{
    boolean result = false;

    @Override
    public void runStep() {
        System.out.println("Running Utility Step");
        execute();

    }

    @Override
    public void initialize() {
        System.out.println("Initializing Utility Step");
    }

    @Override
    public void execute() {
        System.out.println("Executing Utility Step");
        try {
            System.out.println("Execution succesful");
            result = true;
        } catch (Exception e) {
            System.out.println("Error during Utility Step: " + e.getMessage());
            result = false;
        }
        System.out.println("------------------------------");
    }

    @Override
    public boolean publishResult() {
        return result;
    }

}
