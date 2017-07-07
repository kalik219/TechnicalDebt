package com.company;
import java.io.BufferedReader;
//import java.util.*;
import java.io.FileReader;
import java.io.*;
import com.google.common.graph.Network;
import com.google.common.graph.*;

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
         * Starts reading in the CSV file
         */
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            int count = 1; //to keep track of the lines

            String[] arr;
            while ((line = br.readLine()) != null) {

                /**
                 * Will be the first line containing the number of nodes, edges
                 */

                arr = line.split(",");
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == null || arr[i].equalsIgnoreCase("null")) {
                        arr[i] = "0";
                    }
                }
                if (count == 1) {
                    numNodes = Integer.parseInt(arr[0]);
                    numEdges = Integer.parseInt(arr[1]);

                    System.out.println("NumNodes: " + numNodes);
                    System.out.println("NumEdges: " + numEdges);

                } else if (count <= numNodes + 1) {
                    /**
                     *
                     */
                    if (arr.length == 1) {
                        nodes.put(arr[0], new QualityElement(arr[0]));
                    } else if (arr.length == 2) {
                        nodes.put(arr[0], new QualityElement(arr[0], Integer.parseInt(arr[1])));
                    } else {
                        System.out.println("Wrong number of parameters for nodes");
                    }

                } else if (count <= numEdges + 1 && count >= numNodes + 1) {
                    /**
                     * This takes care of creating and inserting the edges
                     */
                    if (arr.length == 4) {
                        edges.put(arr[0], new Impact(arr[0], Integer.parseInt(arr[1])));
                        graph.addEdge(nodes.get(arr[2]), nodes.get(arr[3]), edges.get(arr[0]));
                    } else if (arr.length == 5) {
                        edges.put(arr[0], new Impact(arr[0], Boolean.parseBoolean(arr[1]),
                                Integer.parseInt(arr[2])));
                        graph.addEdge(nodes.get(arr[3]), nodes.get(arr[4]), edges.get(arr[0]));
                    } else {
                        System.out.println("Wrong number of parameters for edges");
                    }
                } else if (count >= numEdges + numNodes + 1) {
                    System.out.println("ERROR: Wrong number of inputs");
                }

                count++;
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(this.graph);

    }


    /**
     * Similar to the aggregation algorithm for the tree, bases aggregation value
     * off of the average value of the leaf nodes
     * @param g graph to perform this on
     * @return integer representing the aggregation value
     */
    public static int aggregateGraph(MutableNetwork<QualityElement, Impact> g) {
        int aggVal = 0;

        /**
         * This original algorithm will just use pre-existing traversal methods
         * to determine which nodes are leaves, and aggregating their multiplicities
         * because that's the only value available to work with at the moment
         */

        //TODO: Make this algorithm possible with any graph and not just a GraphGenerator Object

        return aggVal;
    }

    public int aggregateGG() {
        int aggVal = 0;

        for (String key: this.nodes.keySet()) {
//            if (this.nodes.get(key).reachableNodes().isEmpty()) {
//                aggVal+=
//            }
        }
    }



    public Network<QualityElement, Impact> getGraph() {
        return this.graph;
    }
}
