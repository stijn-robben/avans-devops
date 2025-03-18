package com.example.Pipeline;

public class SourceStep extends PipelineStep{
    boolean result = false;

    @Override
    public void runStep() {
        System.out.println("Running Source Step");
        execute();

    }

    @Override
    public void initialize() {
        System.out.println("Initializing Source Step");
    }

    @Override
    public void execute() {
        System.out.println("Executing Source Step");
        try {
            System.out.println("Execution succesful");
            result = true;
        } catch (Exception e) {
            System.out.println("Error during Source Step: " + e.getMessage());
            result = false;
        }
        System.out.println("------------------------------");
    }

    @Override
    public boolean publishResult() {
        return result;
    }

}
