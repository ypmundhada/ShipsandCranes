package com.company;

public class ToxicContainer extends Container{
    public int containerRisk;
    public ToxicContainer(int containerId, int containerType,int containerWeight,int containerRisk) {
        super(containerId,containerType,containerWeight);
        this.containerRisk = containerRisk;
    }
}
