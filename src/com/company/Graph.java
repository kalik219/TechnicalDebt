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


    public static void main (String args[]) {
        MutableNetwork<QualityElement, Impact> sampleGraph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(true)
                .build();

        System.out.println("Allows self loops: " + sampleGraph.allowsSelfLoops());
        System.out.println("Allows parallel edges: " + sampleGraph.allowsParallelEdges());


        /**
         * 1. Create all the Nodes
         * 2. Create all the edges
         * 3. Connect them somehow
         */


        //creates the nodes
        QualityElement software = new QualityElement("Software");
        QualityElement contentSpoofing = new QualityElement("Content Spoofing");
        QualityElement idva = new QualityElement("Insufficient Verification of Data Authenticity");
        QualityElement identitySpoofing = new QualityElement("Identity Spoofing");
        QualityElement fsod = new QualityElement("Fake Source of Data");
        QualityElement impAuthentication = new QualityElement("Improper Authentication");


        //creates the edges
        Impact a = new Impact("a", false, 5);
        Impact b = new Impact("b", false, 4);
        Impact c = new Impact("c", true, 6);
        Impact d = new Impact("d", true, 2);
        Impact e = new Impact("e", true, 9);
        Impact f = new Impact("f", true, 8);


    }


}
