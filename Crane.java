package com.company;

import java.util.ArrayList;
import java.util.List;

public class Crane {
    private int totalWeight;
    private int totalRisk;
    private int totalPower;
    private int totalSway;
    private List<Container> heavyCon;
    private List<Container> weakCon;
    private List<Container> restOfCon;

    public void stack(List<Container> inputCon,Ship shipObj){
        boolean flag=isPossible(inputCon,shipObj);
        if(!flag){
            System.out.println("NO");
            if(totalWeight>shipObj.getWeightLimit()) System.out.println("Weight of containers is greater than maximum allowed weight");
            if(totalRisk>shipObj.getRiskTolerance())  System.out.println("The risk factor of all the containers is greater than the ship's risk tolerance");
            if(totalSway>shipObj.getSwayTolerance())  System.out.println("The sway of all the liquid containers is greater than the ship's sway tolerance");
            if(totalPower>shipObj.getPowerOutput())   System.out.println("The total power of the containers exceeds the power output of the ship.");
            if(heavyCon.size()>shipObj.getStackLimit())  System.out.println("Its not possible to accommodate heavy containers with the given stack limit");
            if(weakCon.size()>shipObj.getStackLimit())  System.out.println("Its not possible to accommodate weak containers with the given stack limit");
            if(inputCon.size()>shipObj.getStackLimit()*shipObj.getMaxStackHeight())  System.out.println("The maximum container limit has been breached.");
            return ;
        }
        System.out.println("YES");
        shipObj.setFinalAns(new ArrayList<>());
        int hc=0,wc=0,roc=0;
        int lastHeight=0;
        while(hc<heavyCon.size() || wc<weakCon.size() || roc<restOfCon.size()){
            List<Container> lc=new ArrayList<>();
            int currHeight=0;
            if(hc<heavyCon.size()){
                lc.add(heavyCon.get(hc));
                hc++;
                currHeight++;
            }

            while(roc<restOfCon.size() && currHeight<shipObj.getMaxStackHeight()-1){
                lc.add(restOfCon.get(roc));
                roc++;
                currHeight++;
            }
            boolean weakConAdded=false;
            if(wc<weakCon.size()){
                lc.add(weakCon.get(wc));
                wc++;
                currHeight++;
                weakConAdded=true;
            }
            if(!weakConAdded){
                if(roc<restOfCon.size()) {
                    lc.add(restOfCon.get(roc));
                    roc++;
                    currHeight++;
                }
            }
            lastHeight=currHeight;
            Stack st=new Stack(lc,currHeight);
            shipObj.getFinalAns().add(st);
        }

        for(int i=0;i<shipObj.getFinalAns().size();i++){
            Stack st=shipObj.getFinalAns().get(i);
            for(int j=0;j<st.getContainers();j++){
                System.out.print(st.getStackCon().get(j).containerId+" ");
            }
            if(i==shipObj.getFinalAns().size()-1) break;
            System.out.println();
        }

        for(int k=lastHeight+1;k<=shipObj.getMaxStackHeight();k++){
            System.out.print(-1+" ");
        }
        System.out.println();
        for(int i=shipObj.getFinalAns().size()+1;i<=shipObj.getStackLimit();i++){
            for(int j=1;j<=shipObj.getMaxStackHeight();j++){
                System.out.print(-1+" ");
            }
            System.out.println();
        }
    }

    public boolean isPossible(List<Container> inputCon,Ship shipObj){
        heavyCon=new ArrayList<>();
        weakCon=new ArrayList<>();
        restOfCon=new ArrayList<>();
        for(int i=0;i<inputCon.size();i++){
            totalWeight+=inputCon.get(i).containerWeight;
            if(inputCon.get(i).containerType==3 ){
                totalRisk+=((ToxicContainer) inputCon.get(i)).containerRisk;
            }
            if(inputCon.get(i).containerType==4){
                totalRisk+=((ExplosiveContainer) inputCon.get(i)).containerRisk;
            }
            if(inputCon.get(i).containerType==7){
                totalPower+=((RefrigeratedContainer) inputCon.get(i)).containerPower;
            }
            if(inputCon.get(i).containerType==2){
                totalSway+=((LiquidContainer)inputCon.get(i)).containerSway;
            }
            if(inputCon.get(i).containerType==6){
                heavyCon.add(inputCon.get(i));
            }
            else if(inputCon.get(i).containerType==5){
                weakCon.add(inputCon.get(i));
            }
            else{
                restOfCon.add(inputCon.get(i));
            }
        }
        if(totalWeight>shipObj.getWeightLimit() || totalRisk>shipObj.getRiskTolerance() || totalSway>shipObj.getSwayTolerance() || totalPower>shipObj.getPowerOutput()){
            return false;
        }
        if(heavyCon.size()>shipObj.getStackLimit() || weakCon.size()>shipObj.getStackLimit() || inputCon.size()>shipObj.getStackLimit()*shipObj.getMaxStackHeight()){
            return false;
        }
        return true;
    }
}