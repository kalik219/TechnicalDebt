package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import com.google.common.graph.Network;
import com.google.common.graph.*;
import java.util.ArrayList;

import java.util.HashMap;

/**
 * Created by TessaValentien on 7/5/17.
 */

public class GraphGenerator {

    /**
     * This will be my attempt to read in a CSV file and generate a
     * network-graph from it. The idea that it is a graph, but a GraphGenerator
     * Object just takes care of building it.
     */
    private MutableNetwork<QualityElement, Impact> graph;

    private HashMap<String, QualityElement> nodes;

    private HashMap<String, Impact> edges;

    private int numNodes;

    private int numEdges;


    public GraphGenerator(String fileName) {

        /**
         * Builds the graph so properties can be inserted
         */
        graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(true)
                .build();


        /**
         * Instantiates the HashMaps
         */
        nodes = new HashMap<String, QualityElement>();
        edges = new HashMap<String, Impact>();



        /**
         * Starts reading in the CSV file #2 WITH NEW FORMAT OF THE FILE
         */
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            int count = 1; //to keep track of the lines


            String[] arr;
            while ((line = br.readLine()) != null) {

                arr = line.split(",");

                /**
                 * Makes sure nothing is read in as null
                 */
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == null || arr[i].equalsIgnoreCase("null")) {
                        arr[i] = "0";
                    }
                }

                /**
                 * Will be the first line containing the number of nodes, edges
                 */
                if (count == 1) {
                    numNodes = Integer.parseInt(arr[0]);
                    numEdges = Integer.parseInt(arr[1]);


                    //can ignore the other two values if they are there- does not apply here
                    System.out.println("NumNodes: " + numNodes);
                    System.out.println("NumEdges: " + numEdges);

                } else if (count <= numEdges + 1) {
                    /**
                     * This takes care of creating and inserting the edges
                     */
                    if (arr.length == 4) {
                        //if it doesn't have boolean impact
                        edges.put(arr[0], new Impact(arr[0], Integer.parseInt(arr[1])));

                        if (!nodes.containsKey(arr[2])) {
                            nodes.put(arr[2], new QualityElement(arr[2]));
                        }
                        if (!nodes.containsKey(arr[3])) {
                            nodes.put(arr[3], new QualityElement(arr[3]));
                        }

                        graph.addEdge(nodes.get(arr[2]), nodes.get(arr[3]), edges.get(arr[0]));
                    } else if (arr.length == 5) {
                        //if it does have boolean impact
                        edges.put(arr[0], new Impact(arr[0], Boolean.parseBoolean(arr[1]),
                                Integer.parseInt(arr[2])));

                        if (!nodes.containsKey(arr[3])) {
                            nodes.put(arr[3], new QualityElement(arr[3]));
                        }
                        if (!nodes.containsKey(arr[4])) {
                            nodes.put(arr[4], new QualityElement(arr[4]));
                        }

                        graph.addEdge(nodes.get(arr[3]), nodes.get(arr[4]), edges.get(arr[0]));
                    } else {
                        System.out.println("Wrong number of parameters for edges");
                    }

                } else if (count <= numEdges + numNodes + 1 && count >= numEdges + 1) {

                    /**
                     * Creates and saves uncreated Nodes, and updates the information of those
                     * created for the edges above.
                     */
                   if (nodes.get(arr[0]) != null /*!nodes.containsKey(arr[0])*/) {
                       nodes.get(arr[0]).setMultiplicity(Integer.parseInt(arr[1]));
                   } else {
                       nodes.put(arr[0], new QualityElement(arr[0], Integer.parseInt(arr[1])));
                   }
                }
                count++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * Algorithm #1 - see README
     * Only for graphGenerator Objects
     * @return an aggregation value
     */
    public double aggregateGG() {
        double aggVal = 0;
        int numLeaves = 0;

        for (String key: this.nodes.keySet()) {
            /**
             * Goes through the HashMap of nodes to just check to see if it's a leaf
             * and if it is, add the multiplicity (for convenience) to the aggVal
             * Logic: it will be a leaf if you can't reach any nodes from it because of
             * the assumption that the inputted graph is a tree.
             */
            if (Graphs.reachableNodes(this.graph.asGraph(), this.nodes.get(key)).isEmpty()) {
                aggVal+= this.nodes.get(key).getMultiplicity();
                numLeaves++;
            }
        }
        System.out.println("NumLeaves: " + numLeaves);
        return aggVal/numLeaves;
    }


    /**
     * Algorithm #2 - see README
     * Also only for GraphGenerator objects because utilizes the HashMaps
     * //TODO: Test this code
     * @return aggregation value
     */
    public double aggregateIGG() {
        double aggVal = 0;
        int numLeaves = 0;

        /**
         * Goes through the HashMap of nodes to check if it's a leaf
         * If it is, add the multiplicity to the aggVal
         * Logic: if it is a leaf in an inverted tree, there will be no inEdges()
         * (Nothing pointing to it)
         */
        for (String key: this.nodes.keySet()) {
            if (this.graph.inEdges(this.nodes.get(key)).isEmpty()) {
                numLeaves++;
                aggVal += this.nodes.get(key).getMultiplicity();
            }
        }
        return aggVal/numLeaves;
    }


    /**
     * Static method that should work with any Guava network- uses same logic
     * as aggregateIGG()
     * @param g graph for this to be performed on since it's static
     * @return aggregation value between 0 and 1 (as percentage)
     */
    public static double evaluate(MutableNetwork<QualityElement, Impact> g) {
        /**
         * Should use the built-in iterator for Graphs (find it) and essentially
         * do the same thing as the other two algorithms by checking for leaf nodes
         */

        ArrayList<Integer> mults = new ArrayList<Integer>();
        double aggVal = 0;
        int numLeaves = 0;

        int count = 0;
        for (QualityElement qe: g.nodes()) {
            if (g.inEdges(qe).isEmpty()) {
                numLeaves++;
                aggVal += qe.getMultiplicity();
                mults.add(qe.getMultiplicity());
            }
            count ++;
        }
        System.out.println("This is the mults in this graph: " + mults.toString());
        System.out.println("This is the number of leaves:  " + numLeaves);
        double temp =  aggVal/numLeaves;

        return temp/100;
    }


    public HashMap<String, QualityElement> getNodes() {
        return this.nodes;
    }


    public HashMap<String, Impact> getEdges() {
        return this.edges;
    }

    /**
     * Just has the hashMap of nodes and edges for now
     * @return String of nodes and edges WITHOUT connections
     */
    public String toString() {
        String ret = "\nBEGIN PRINTING GRAPH: **********\n";
        ret += "Nodes: \n";
        for (String key: this.nodes.keySet()) {
            ret+= this.nodes.get(key).getFactorType() + " \n";
        }

        ret+= "\nEdges: \n";

        for (String key: this.edges.keySet()) {
            ret+= this.edges.get(key).getDesc() + " \n";
        }

        ret+= "DONE PRINTING GRAPH ********** \n";

        return ret;
    }


    /**
     * Getter method for the graph
     * @return the graph
     */
    public Network<QualityElement, Impact> getGraph() {
        return this.graph;
    }
}
