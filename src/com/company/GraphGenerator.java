package com.company;
import java.io.BufferedReader;
import java.util.*;
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


    //TODO: Please note that this code doesn't work yet


    private Network<QualityElement, Impact> graph;

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
                //TODO: fill this in properly

                /**
                 * Will be the first line containing the number of nodes, edges
                 */

                arr = line.split(",");
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == null || arr[i].equalsIgnoreCase("null")) {
                        arr[i] = "0";
                    }
                }

                //System.out.print(arr.length + " ");
                if (count == 1) {
                    numNodes = Integer.parseInt(arr[0]);
                    numEdges = Integer.parseInt(arr[1]);

                    System.out.println("NumNodes: " + numNodes);
                    System.out.println("NumEdges: " + numEdges);
                } else if (count <= numNodes + 1) {
                    if (arr.length == 1) {
                        nodes.put(arr[0], new QualityElement(arr[0]));
                    } else if (arr.length == 2) {
                        nodes.put(arr[0], new QualityElement(arr[0], Integer.parseInt(arr[1])));
                    } else {
                        System.out.println("Wrong number of parameters for nodes");
                    }

                } else if (count <= numEdges + 1 && count >= numNodes + 1) {
                    if (arr.length == 2) {
                        edges.put(arr[0], new Impact(arr[0], Integer.parseInt(arr[1])));
                    } else if (arr.length == 3) {
                        edges.put(arr[0], new Impact(arr[0], Boolean.parseBoolean(arr[1]),
                                Integer.parseInt(arr[2])));
                    } else {
                        System.out.println("Wrong number of parameters for edges");
                    }
                }

                //TODO: Take care of inserting edges - requires modification of CSV file




                count++;
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }



    public Network<QualityElement, Impact> getGraph() {
        return this.graph;
    }
}
