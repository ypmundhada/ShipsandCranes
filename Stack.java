package com.company;

import java.util.List;

public class Stack {
    private int totalContainers;
    private List<Container> stackCon;

    public Stack(List<Container> stackCon,int totalContainers) {
        this.totalContainers = totalContainers;
        this.stackCon = stackCon;
    }

    public List<Container> getStackCon() {
        return stackCon;
    }

    public void setStackCon(List<Container> stackCon) {
        this.stackCon = stackCon;
    }

    public int getContainers() {
        return totalContainers;
    }

    public void setContainers(int totalContainers) {
        this.totalContainers = totalContainers;
    }
}