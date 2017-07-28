package com.company;
import com.google.common.graph.Network;
import com.google.common.graph.*;
import java.io.*;

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


        System.out.println("The following lines of output are for the sample graph built in Graph.java to" +
                "\nshow how a Google Guava graph is built in code.");
        System.out.println("Allows self loops: " + sampleGraph.allowsSelfLoops());
        System.out.println("Allows parallel edges: " + sampleGraph.allowsParallelEdges());


        /**
         * 1. Create all the Nodes
         * 2. Create all the edges
         * 3. Connect the nodes using the edges
         */


        /**
         * This is an example of how nodes would be created:
         */
        QualityElement software = new QualityElement("Software");
        QualityElement contentSpoofing = new QualityElement("Content Spoofing");
        QualityElement ivda = new QualityElement("Insufficient Verification of Data Authenticity");
        QualityElement identitySpoofing = new QualityElement("Identity Spoofing");
        QualityElement fsod = new QualityElement("Fake Source of Data");
        QualityElement impAuthentication = new QualityElement("Improper Authentication");


        /**
         * This is an example of how edges would be created:
         */
        Impact a = new Impact("a", false, 5);
        Impact b = new Impact("b", false, 4);
        Impact c = new Impact("c", true, 6);
        Impact d = new Impact("d", true, 2);
        Impact e = new Impact("e", true, 9);
        Impact f = new Impact("f", true, 8);

        /**
         * This is how you would "build" the graph using the Guava Graphs library.
         */
        sampleGraph.addEdge(identitySpoofing, software, a);
        sampleGraph.addEdge(contentSpoofing, software, b);
        sampleGraph.addEdge(ivda, contentSpoofing, c);
        sampleGraph.addEdge(identitySpoofing, fsod, d);
        sampleGraph.addEdge(impAuthentication, identitySpoofing, e);

        /**
         * Actual edge
         */
        sampleGraph.addEdge(fsod, impAuthentication, f);


        /**
         * Switches the direction of the edge to see if hasCycle() method
         * takes into consideration the direction (it does)
         */
        //sampleGraph.addEdge(impAuthentication, fsod, f);


        System.out.println("Does it have a cycle?: " + Graphs.hasCycle(sampleGraph));


        /**
         * The following code is only intended to figure out how the transitiveClosure() method
         * provided by the graphs class works (it returns a directed graph and it does work)
         */

        System.out.println("This is the transitive closure graph: ");

        System.out.println(Graphs.transitiveClosure(sampleGraph.asGraph()));

        System.out.println("\n\n\nThis is starting with GRAPH1.csv");

        GraphGenerator sample = new
                GraphGenerator("/Users/TessaValentien/Documents/MSU_TechnicalDebt_REU/GRAPH1.csv");

        System.out.println("sample toString(): " + sample.toString());

        System.out.println("The following retVal is the result of the static evaluate() method: ");

        double retVal = GraphGenerator.evaluate((MutableNetwork) sample.getGraph());

        System.out.println("retVal: " + retVal);

        System.out.println("\nThe next two lines use aggregateGG() which has the inverted directions of edges: ");

        System.out.println("Sample aggregateGG(): " + sample.aggregateGG());

        System.out.println("\nThe next one (aggregateIGG()) considers the graph a \"tree\" if it has" +
                "\nthe same structure as a tree with inverted edges which is how the " +
                "\nquality model is structured: ");

        System.out.println("Sample aggregateIGG(): " + sample.aggregateIGG());

        System.out.println("\nNodes (from Guava's asGraph() method): " + sample.getGraph().nodes().size());

        System.out.println("Edges (from Guava's asGraph() method): " + sample.getGraph().edges().size());

        System.out.println("\n\n" + sample.getGraph());

    }


}
