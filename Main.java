package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the total number of Stacks the ship has");
        int numOfStacks = Integer.parseInt(br.readLine());
        System.out.println("Enter the maximum Height of a stack");
        int maxStackSize = Integer.parseInt(br.readLine());
        System.out.println("Enter the Weight Limit of the ship");
        int weightLimit = Integer.parseInt(br.readLine());
        System.out.println("Enter the Sway Tolerance level of the ship");
        int swayTolerance = Integer.parseInt(br.readLine());
        System.out.println("Enter the Risk Tolerance level of the ship");
        int riskTolerance = Integer.parseInt(br.readLine());
        System.out.println("Enter the maximum Power Output level of the ship");
        int powerOutput = Integer.parseInt(br.readLine());
        System.out.println("Enter the number of containers to be stacked");
        int numOfContainers = Integer.parseInt(br.readLine());
        Ship ship = new Ship(numOfStacks,riskTolerance,swayTolerance,weightLimit,maxStackSize,powerOutput);
        ArrayList<Container> contArray = new ArrayList<>();
        System.out.println("Enter the specifications of each container in the order -> Container ID, Container Type ID, Weight");
        System.out.println("For Liquid, Toxic, Explosive and Refrigerated Container enter additional value for Sway, Risk and Power respectively");
        for(int i=0;i<numOfContainers;i++){
            String[] argsList = br.readLine().split(" ");
            int containerId = Integer.parseInt(argsList[0]);
            int containerTypeId = Integer.parseInt(argsList[1]);
            Container cont;
            switch (containerTypeId) {
                case 1 -> {
                    cont = new SimpleContainer(containerId, containerTypeId, Integer.parseInt(argsList[2]));
                    contArray.add(cont);
                }
                case 2 -> {
                    cont = new LiquidContainer(containerId, containerTypeId, Integer.parseInt(argsList[2]),Integer.parseInt(argsList[3]));
                    contArray.add(cont);
                }
                case 3 -> {
                    cont = new ToxicContainer(containerId, containerTypeId, Integer.parseInt(argsList[2]),Integer.parseInt(argsList[3]));
                    contArray.add(cont);
                }
                case 4 -> {
                    cont = new ExplosiveContainer(containerId, containerTypeId, Integer.parseInt(argsList[2]),Integer.parseInt(argsList[3]));
                    contArray.add(cont);
                }
                case 5 -> {
                    cont = new WeakContainer(containerId, containerTypeId, Integer.parseInt(argsList[2]));
                    contArray.add(cont);
                }
                case 6 -> {
                    cont = new HeavyContainer(containerId, containerTypeId, Integer.parseInt(argsList[2]));
                    contArray.add(cont);
                }
                case 7 -> {
                    cont = new RefrigeratedContainer(containerId, containerTypeId, Integer.parseInt(argsList[2]),Integer.parseInt(argsList[3]));
                    contArray.add(cont);
                }
            }

        }
        Crane cr = new Crane();
        cr.stack(contArray,ship);
    }
}