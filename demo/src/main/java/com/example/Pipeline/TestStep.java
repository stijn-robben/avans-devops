package com.example.Pipeline;

public class TestStep extends PipelineStep{
    boolean result = false;

    @Override
    public void runStep() {
        System.out.println("Running Testing Step");
        execute();

    }

    @Override
    public void initialize() {
        System.out.println("Initializing Testing Step");
    }

    @Override
    public void execute() {
        System.out.println("Executing Test Step");
        try {
            System.out.println("Execution succesful");
            result = true;
        } catch (Exception e) {
            System.out.println("Error during Test Step: " + e.getMessage());
            result = false;
        }
        System.out.println("------------------------------");
    }

    @Override
    public boolean publishResult() {
        return result;
    }

}
