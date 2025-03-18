package com.example.Pipeline;

import java.util.List;

public class Pipeline {
    private String name;
    private List<PipelineStep> steps;
    private PipelineStepFactory stepFactory;

    public void addStep(PipelineStep step) {
        steps.add(step);
    }

    public void runAllSteps() {
        
        for (PipelineStep step : steps) {
            step.runStep();
        }
    }

    public void createAndAddStep(String stepType) {
        // Method implementation
    }
}