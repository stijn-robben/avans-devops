package com.example.Pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pipeline {
    private String name;
    private List<PipelineStep> steps;
    private PipelineStepFactory stepFactory;

    public Pipeline(String name) {
        this.name = name;
        this.steps = new ArrayList<>();
        this.stepFactory = new PipelineStepFactory();
        System.out.println("\n\n\nPipeline created: " + name);
        initializeSteps();
    }

    private void initializeSteps() {
        System.out.println("Initializing steps");
        Map<String, PipelineStep> allSteps = stepFactory.getAllSteps();
        for (PipelineStep step : allSteps.values()) {
            addStep(step);
        }
    }

    public void addStep(PipelineStep step) {
        steps.add(step);
    }

    public void runAllSteps() {
        for (PipelineStep step : steps) {
            step.runStep();
            if (!step.publishResult()) {
                System.out.println("Step failed: " + step.getClass().getSimpleName() + "\nExecution steps stopped");
                break;
            } 
        }
    }

    
}