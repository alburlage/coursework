//DO NOT REMOVE PACKAGE LIN
//Without this line autograder will not run correctly.
//You can comment it while you work on the problem.
//When everything works - uncomment and submit!
//package com.gradescope.hw3;

//Due to limitations by the autograder and JUnit, this class must be a separate public class.
//However, the best practice is to make it private class inside the List object.
public class DoubleIntNode {
    //Add appropriate instance variables/fields. Note that proper encapsulation is
    //not being adhered to in this project. We need the Tester class to be able to
    //access the previous and next pointers directly. Choose your modifiers carefully.


    // Due to limitations by the autograder and JUnit, this class must be a separate public class.
// However, the best practice is to make it a private class inside the List object.

    // Instance variables
    public int data;                // Data for the node
    public DoubleIntNode prev;            // Previous node reference
    public DoubleIntNode next;            // Next node reference


    // Constructor with data, previous, and next nodes
    public DoubleIntNode(DoubleIntNode prev,int data,  DoubleIntNode next) {
        this.data = data;             // Set the data
        this.prev = prev;             // Set the previous node
        this.next = next;             // Set the next node
    }

    // Constructor with only data
    public DoubleIntNode(int data) {
        this(null, data, null);      // Call the main constructor with prev and next as null
    }
}
