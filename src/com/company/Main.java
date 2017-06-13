package com.company;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("This is the aggregated security severity metric of the inputted attack tree: ");

        /**
         * Create the nodes first without constructor so you can make
         * adjacency lists for later instantiation.
         */

        ATNode attack = new ATNode(1, "Attack");
        ATNode anticipated = new ATNode(2, "Anticipated");
        ATNode unanticipated = new ATNode(7, "Unanticipated");
        ATNode exploitation = new ATNode(4, "Exploitation");
        ATNode injection = new ATNode(6, "Injection");
        ATNode spoofing = new ATNode(3, "Spoofing");


        AttackTree a = new AttackTree(attack);
        System.out.println(a.getRoot().getAttackType());

        a.addNode(a.getRoot(), anticipated);
        a.addNode(a.getRoot(), unanticipated);

        a.addNode(anticipated, exploitation);
        a.addNode(anticipated, injection);
        a.addNode(anticipated, spoofing);

        System.out.println(a.aggregate());

        System.out.println("Hello world"); 
    }
}
