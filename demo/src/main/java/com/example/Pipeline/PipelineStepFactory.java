package com.example.Pipeline;

import java.util.LinkedHashMap;
import java.util.Map;

public class PipelineStepFactory {
    private Map<String, PipelineStep> steps;

    public PipelineStepFactory() {
        steps = new LinkedHashMap<>();
        steps.put("Source", new SourceStep());
        steps.put("Analyze", new AnalyzeStep());
        steps.put("Build", new BuildStep());
        steps.put("Test", new TestStep());
        steps.put("Package", new PackageStep());
        steps.put("Utility", new UtilityStep());
        steps.put("Deploy", new DeployStep());
    }

    public PipelineStep createStep(String stepType) {
        return steps.get(stepType);
    }

    public Map<String, PipelineStep> getAllSteps() {
        return steps;
    }
}