package com.company;

public class LiquidContainer extends Container{
    public int containerSway;
    public LiquidContainer(int containerId, int containerType,int containerWeight,int containerSway) {
        super(containerId,containerType,containerWeight);
        this.containerSway = containerSway;
    }
}