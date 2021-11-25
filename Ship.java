package com.company;

import java.util.List;

public class Ship {
    private int stackLimit;
    private int riskTolerance;
    private int swayTolerance;
    private int weightLimit;
    private int maxHeight;
    private int powerOutput;
    private List<Stack> finalAns;


    public Ship(int stackLimit, int riskTolerance,
                int swayTolerance, int weightLimit,
                int maxHeight, int powerOutput) {
        this.stackLimit = stackLimit;
        this.riskTolerance = riskTolerance;
        this.swayTolerance = swayTolerance;
        this.weightLimit = weightLimit;
        this.maxHeight = maxHeight;
        this.powerOutput = powerOutput;
    }

    public int getStackLimit() {
        return stackLimit;
    }

    public void setStackLimit(int stackLimit) {
        this.stackLimit = stackLimit;
    }

    public int getRiskTolerance() {
        return riskTolerance;
    }

    public void setRiskTolerance(int riskTolerance) {
        this.riskTolerance = riskTolerance;
    }

    public int getSwayTolerance() {
        return swayTolerance;
    }

    public void setSwayTolerance(int swayTolerance) {
        this.swayTolerance = swayTolerance;
    }

    public int getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(int weightLimit) {
        this.weightLimit = weightLimit;
    }

    public int getMaxStackHeight() {
        return maxHeight;
    }

    public void setMaxStackHeight(int maxStackHeight) {
        this.maxHeight = maxStackHeight;
    }

    public int getPowerOutput() {
        return powerOutput;
    }

    public void setPowerOutput(int powerOutput) {
        this.powerOutput = powerOutput;
    }

    public List<Stack> getFinalAns() {
        return finalAns;
    }

    public void setFinalAns(List<Stack> finalAns) {
        this.finalAns = finalAns;
    }
}
