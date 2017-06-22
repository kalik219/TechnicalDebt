package com.company;
import com.google.common.graph.Network;
import com.google.common.graph.*;

/**
 * Created by TessaValentien on 6/14/17.
 */
public class Graph {
    /**
     * should be virtually the same as AttackTree, but we can have different types of nodes
     */

    /**
     * Just kidding, use Google Guava Graph (probably using network) and
     * 1. Check to see if there is a cycle (there will be two separate algorithms)
     * 2. Traverse the tree and keep track of how many times a node is visited in a traversal (for cycle?)
     * --> this may affect the severity --> not so much the weight or the depth
     *
     */
     public Graph(GNode root) {



    }


    public static void main (String args[]) {
        MutableGraph<Integer> graph = GraphBuilder.directed().build();
        graph.addNode(1);
        graph.putEdge(2, 3);  // also adds nodes 2 and 3 if not already present

        System.out.println("HI");

    }


}
