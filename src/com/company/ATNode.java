package com.company;
import java.util.ArrayList;

/**
 * Created by TessaValentien on 6/12/17.
 */
public class ATNode {
    //instance variables
    private int weight;
    private ArrayList<ATNode> adj;
    private int depth;
    private boolean visited;
    private String attackType;


    public ATNode(int w, String s) {
        this.weight = w;
        this.adj = new ArrayList<ATNode>();
        this.visited = false;
        this.attackType = s;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int w) {
        this.weight = w;
    }

    public int getDepth() {
        return this.depth;
    }

    public void setDepth(int d) {
        this.depth = d;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void setVisited(boolean b) {
        this.visited = b;
    }

    public String getAttackType() {
        return this.attackType;
    }

    public void setAttackType(String s) {
        this.attackType = s;
    }

    public ArrayList<ATNode> getAdj() {
        return this.adj;
    }


}