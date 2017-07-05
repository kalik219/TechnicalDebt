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

    private HashMap<String, QualityElement> map;



    public GraphGenerator(String fileName) {

        graph = null;

        List<QualityElement> temp = new ArrayList<QualityElement>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            System.out.println("Did we get to here?");
            String line;

            while ((line = br.readLine()) != null) {
                //TODO: fill this in properly
                System.out.print(line + "     ");

                //add it to data structure
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //return temp;

    }



    public Network<QualityElement, Impact> getGraph() {
        return this.graph;
    }
}
