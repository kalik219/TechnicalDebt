package com.company;
import java.io.BufferedReader;
import java.util.*;
import java.io.FileReader;
import java.io.*;


/**
 * Created by TessaValentien on 7/5/17.
 */

public class GraphGenerator {

    /**
     * This will be my attempt to read in a CSV file and generate a
     * network-graph from it
     */


    //TODO: Please note that this code doesn't work yet


    public GraphGenerator(String fileName) {

        List<QualityElement> temp = new ArrayList<QualityElement>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
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
}
