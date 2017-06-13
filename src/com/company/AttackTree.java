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

    /**
     * Should really find a way to generate the tree given some inputs
     * in a CSV list for example?
     */

    public AttackTree(ATNode root) {
        this.size = 1;
        this.totalDepth = 1;
        this.root = root;
        this.numLeaves = 0;
    }

    /**
     * Should be the only method in which we modify a node's adjacency
     * list to properly keep track of size
     * @param subRoot
     * @param newNode
     */
    public void addNode(ATNode subRoot, ATNode newNode) {
        //Sets total depth of tree if necessary
        /**
         * TODO: Make sure that this handles other branches as well
         */
        if (subRoot.getAdj().isEmpty()) {
            this.totalDepth++;
        }

        //sets the depth of the new node (will happen either way)
        newNode.setDepth(subRoot.getDepth() + 1);
        subRoot.getAdj().add(newNode);
        this.size++;
    }

    /**
     * This will act as main DFS method
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

    public int getSize() {
        return this.size;
    }

    public int getTotalDepth() {
        return this.totalDepth;
    }

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

    public ATNode getRoot() {
        return this.root;
    }
}