package com.example.Pipeline;

public class DeployStep extends PipelineStep{
    boolean result = false;

    @Override
    public void runStep() {
        System.out.println("Running Deploy Step");
        execute();

    }

    @Override
    public void initialize() {
        System.out.println("Initializing Deploy Step");
    }

    @Override
    public void execute() {
        System.out.println("Executing Deploy Step");
        try {
            System.out.println("Execution succesful");
            result = true;
        } catch (Exception e) {
            System.out.println("Error during Deploy Step: " + e.getMessage());
            result = false;
        }
        System.out.println("------------------------------");
    }

    @Override
    public boolean publishResult() {
        return result;
    }

}
