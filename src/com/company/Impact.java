package com.company;

/**
 * Created by TessaValentien on 6/26/17.
 */
public class Impact {
    /**
     * This class represents the edges in the graph
     */
    private String description;

    private int weight;

    /**
     * True = positive impact
     * False = negative impact
     * NOTE: might make this an integer value later
     */
    private boolean parity; //whether it's a positive or negative impact

    /**
     * Constructor for Impact
     * @param desc description of impact
     * @param p whether it's positive or negative
     * @param w weight
     */
    public Impact(String desc, boolean p, int w) {
        this.description = desc;
        this.parity = p;
        this.weight = w;
    }

}
