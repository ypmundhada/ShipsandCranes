package com.company;

public class RefrigeratedContainer extends Container{
    public int containerPower;
    public RefrigeratedContainer(int containerId, int containerType,int containerWeight,int containerPower) {
        super(containerId,containerType,containerWeight);
        this.containerPower = containerPower;
    }
}