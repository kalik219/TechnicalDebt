package com.company;

/**
 * Created by TessaValentien on 6/12/17.
 */
public class AttackTree {

    //instance variables
    private int size;
    private int totalDepth;
    private int aggVal;
    private ATNode root;
    private int numLeaves;
    private int maxDepth;
    private String ret; //for toString()

    /**
     * Should really find a way to generate the tree given some inputs
     * in a CSV list for example?
     */

    /**
     * Constructor for an attack tree
     * @param root desired root of the new attack tree
     * @return new Attack Tree
     */
    public AttackTree(ATNode root) {
        this.size = 1;
        this.totalDepth = 1;
        this.root = root;
        this.numLeaves = 0;
        this.maxDepth = 1;
        this.ret = ""; //before calling toString()
    }

    /**
     * Should be the only method in which we modify a node's adjacency
     * list to properly keep track of size; will also keep track of depth
     * @param subRoot node whose adjacency list the newNode will be appended to
     * @param newNode node to be added to the Attack Tree
     */
    public void addNode(ATNode subRoot, ATNode newNode) {

        //sets the depth of the new node (will happen either way)
        newNode.setDepth(subRoot.getDepth() + 1);
        if (newNode.getDepth() > this.maxDepth) {
            maxDepth = newNode.getDepth();
            this.totalDepth = newNode.getDepth();
        }
        subRoot.getAdj().add(newNode);
        this.size++;
    }

    /**
     * Is the base DFS method
     * NOTE: aggVal is only significant after this method is called
     * @return aggregation value based on average weights of the leaves
     */
    public double aggregate() {
        if (null == root) {
            return 0;
        }

        if (root.getAdj() != null) {
            if (root.getAdj().isEmpty()) {
                return root.getWeight();
            } else {
                //Go through all the nodes in the adjacency list of the root
                for (int i = 0; i < root.getAdj().size(); i++) {
                    if (this.root.getAdj().get(i).isVisited() == false) {
                        aHelper(this.root.getAdj().get(i));
                    }
                }
            }
        }

        //System.out.println("This is the aggVal: " + aggVal);
        return (double)aggVal/this.numLeaves;

    }

    /**
     * Recursive helper method for aggregate()
     * @param v node to be "exploring"
     */
    public void aHelper(ATNode v) {
        v.setVisited(true);
        if (v.getAdj().isEmpty()) {
            /**
             * This is a leaf node --> calculate the weight of it
             * For now, the aggregated value is just the average of the weights
             * of the leaf nodes
             */

            numLeaves++;
            aggVal += v.getWeight();
        }

        //go through adjacency list
        for (int i = 0; i < v.getAdj().size(); i++) {
            if (v.getAdj().get(i).isVisited() == false) {
                aHelper(v.getAdj().get(i));
            }
        }
    }

    /**
     * Getter for size
     * @return size of AttackTree
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Getter for total depth
     * @return maximum depth of the attack tree
     */
    public int getTotalDepth() {
        return this.totalDepth;
    }

    /**
     * Getter for numleaves
     * @return number of leaves
     */
    public int getNumLeaves() {
        return this.numLeaves;
    }


    /**
     * NOTE: This does not return the official aggregated value before calling aggregate()
     * @return the current state of aggVal
     */
    public int getAggVal() {
        return this.aggVal;
    }

    /**
     * Getter for root
     * @return root of the attack tree
     */
    public ATNode getRoot() {
        return this.root;
    }


    /**
     * Uses DFS to show the tree in adjacency list format
     * @return
     */
    public String toString() {
        ret = "";
        if (null == root) {
            return ret;
        }

        if (root.getAdj() != null) {
            if (root.getAdj().isEmpty()) {
                ret += root.toString();
                return ret;
            } else {
                //Go through all the nodes in the adjacency list of the root
                ret += root.toString() + "\n";
                for (int i = 0; i < root.getAdj().size(); i++) {
                    toStringHelper(this.root.getAdj().get(i));
                }
            }
        }

        return ret;
    }

    public void toStringHelper(ATNode v) {

        if (v.getAdj().isEmpty()) {
            /**
             * This is a leaf node --> calculate the weight of it
             * For now, the aggregated value is just the average of the weights
             * of the leaf nodes
             */
            ret += v.toString() + "\n";
        }

        //go through adjacency list
        for (int i = 0; i < v.getAdj().size(); i++) {
            ret += v.toString() + "\n";
            toStringHelper(v.getAdj().get(i));
        }
    }

}