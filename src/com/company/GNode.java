package com.company;
import java.util.ArrayList;

/**
 * Created by TessaValentien on 6/14/17.
 */
public class GNode {
    //instance variables
    private int weight;
    private ArrayList<GNode> adj;
    private int depth;
    private boolean visited;
    private String type;


    /**
     * Constructor for a general graph node
     * @param w weight of the node (if it has one)
     * @param s string that says what type of node it is
     */
    public GNode(int w, String s) {
        this.weight = w;
        this.adj = new ArrayList<GNode>();
        this.visited = false;
        this.type = s;
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
     * Getter for type
     * @return type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Setter for type
     * @param s type to be set
     */
    public void setType(String s) {
        this.type = s;
    }

    /**
     * Getter for adjacency list
     * @return adjacency list
     */
    public ArrayList<GNode> getAdj() {
        return this.adj;
    }


}