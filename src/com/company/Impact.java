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

    /**
     * Overloads the constructor - mainly to accommodate
     * format of sample CSV file for now
     * @param desc description of impact
     * @param w weight
     */
    public Impact(String desc, int w) {
        this.description = desc;
        this.parity = false;
        this.weight = w;
    }

    /**
     * Getter for description
     * @return description
     */
    public String getDesc() {
        return this.description;
    }

    /**
     * Getter for parity
     * @return parity
     */
    public boolean getParity() {
        return this.parity;
    }

    /**
     * Getter for weight
     * @return weight
     */
    public int getWeight() {
        return this.weight;
    }

    /**
     * Setter for description
     * @param toSet what to set the description to
     */
    public void setDesc(String toSet) {
        this.description = toSet;
    }

    /**
     * Setter for parity
     * @param toSet what to set the parity to
     */
    public void setParity(boolean toSet) {
        this.parity = toSet;
    }

    /**
     * Setter for weight
     * @param toSet what to set the weight to
     */
    public void setWeight(int toSet) {
        this.weight = toSet;
    }

}
