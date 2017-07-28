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

        System.out.println("Allows self loops: " + sampleGraph.allowsSelfLoops());
        System.out.println("Allows parallel edges: " + sampleGraph.allowsParallelEdges());


        /**
         * 1. Create all the Nodes
         * 2. Create all the edges
         * 3. Connect the nodes using the edges
         * 4. Run tests on the graph to see if it's actually
         * the graph you think you made
         * UPDATE: can likely include info for 3 and 4 on the same line
         * and execute in the same loop
         */


        //creates the nodes
        QualityElement software = new QualityElement("Software");
        QualityElement contentSpoofing = new QualityElement("Content Spoofing");
        QualityElement ivda = new QualityElement("Insufficient Verification of Data Authenticity");
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

        //connects the nodes using the edges
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



        //TODO: Write out the potential implications of it having a cycle
        System.out.println("Does it have a cycle?: " + Graphs.hasCycle(sampleGraph));



        /**
         * The following code is only intended to figure out how the transitiveClosure() method
         * provided by the graphs class works (it returns a directed graph and it does work)
         */

        System.out.println("This is the transitive closure graph: ");

        System.out.println(Graphs.transitiveClosure(sampleGraph.asGraph()));



//        try {
//            FileReader file = new FileReader("/Users/TessaValentien/Documents/MSU_TechnicalDebt_REU/sampleCSV.csv");
//        } catch (IOException x) {
//            x.printStackTrace();
//        }


//        GraphGenerator sample2 = new
//                GraphGenerator("/Users/TessaValentien/Documents/MSU_TechnicalDebt_REU/sampleCSV.csv");

        System.out.println("\n\n\nThis is starting with GRAPH1.csv");

        GraphGenerator sample3 = new
                GraphGenerator("/Users/TessaValentien/Documents/MSU_TechnicalDebt_REU/GRAPH1.csv");

//        System.out.println("Sample2 toString: " + sample2.toString());
//        System.out.println("Sample2 aggregateGG(): " + sample2.aggregateGG());
//        System.out.println("Sample2.aggregateIGG(): " + sample2.aggregateIGG());
//        System.out.println();

//        System.out.println("This is the static method evaluate: ");
//        double retVal = GraphGenerator.evaluate((MutableNetwork) sample2.getGraph());

//        System.out.println(retVal);



        double retVal = GraphGenerator.evaluate((MutableNetwork) sample3.getGraph());

        System.out.println("RetVal: " + retVal);

        System.out.println("Sample2 aggregateGG(): " + sample3.aggregateGG());
        System.out.println("Sample2.aggregateIGG(): " + sample3.aggregateIGG());


//        /**
//         * Prints the nodes from the keyset
//         */
//        int nodeCount = 0;
//        for (String k : sample3.getNodes().keySet()) {
//            System.out.println(sample3.getNodes().get(k).toString() + " " + nodeCount);
//            nodeCount++;
//        }
//
//        System.out.println("Testing nodeCount: " + nodeCount);

        System.out.println("From asGraph(): " + sample3.getGraph().nodes().size());



//        System.out.println();
//
//        int edgeCount = 1;
//        for (String k : sample3.getEdges().keySet()) {
//            System.out.println(sample3.getEdges().get(k).toString() + " " + edgeCount);
//            edgeCount++;
//        }

        System.out.println(sample3.getGraph());


        System.out.println(retVal);
    }


}
