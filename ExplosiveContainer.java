package com.company;

public class ExplosiveContainer extends Container{
    public int containerRisk;
    public ExplosiveContainer(int containerId, int containerType,int containerWeight,int containerRisk) {
        super(containerId,containerType,containerWeight);
        this.containerRisk = containerRisk;
    }
}