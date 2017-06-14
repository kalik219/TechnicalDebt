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


    /**
     * Constructor for an AttackTree Node
     * @param w weight of the node (or attack type)
     * @param s string that represents the attack type
     */
    public ATNode(int w, String s) {
        this.weight = w;
        this.adj = new ArrayList<ATNode>();
        this.visited = false;
        this.attackType = s;
    }

    /**
     * Getter for weight
     * @return weight of node
     */
    public int getWeight() {
        return this.weight;
    }

    /**
     * Setter for weight
     * @param w new weight
     */
    public void setWeight(int w) {
        this.weight = w;
    }

    /**
     * Getter for depth
     * @return depth of node
     */
    public int getDepth() {
        return this.depth;
    }

    /**
     * Setter for depth
     * @param d depth to be set
     */
    public void setDepth(int d) {
        this.depth = d;
    }

    /**
     * Checks to see if node has been visited
     * @return whether the node has been visited
     */
    public boolean isVisited() {
        return this.visited;
    }

    /**
     * Allows visited to be toggled and set
     * @param b what value should be toggled (or not toggled) to
     */
    public void setVisited(boolean b) {
        this.visited = b;
    }

    /**
     * Getter for attack type
     * @return attackType
     */
    public String getAttackType() {
        return this.attackType;
    }

    /**
     * Setter for attack type
     * @param s attackType to be set
     */
    public void setAttackType(String s) {
        this.attackType = s;
    }

    /**
     * Getter for adjacency list
     * @return adjacency list
     */
    public ArrayList<ATNode> getAdj() {
        return this.adj;
    }


}