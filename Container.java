package com.company;

public abstract class Container {
        public int containerId;
        public int containerType;
        public int containerWeight;
        public Container(int containerId, int containerType,int containerWeight){
                this.containerId = containerId;
                this.containerType = containerType;
                this.containerWeight = containerWeight;
        }
}