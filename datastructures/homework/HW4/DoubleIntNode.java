//DO NOT REMOVE PACKAGE LINE
//Without this line autograder will not run correctly.
//You can comment it while you work on the problem.
//When everything works - uncomment and submit!
//package com.gradescope.hw3;

//Due to limitations by the autograder and JUnit, this class must be a separate public class.
//However, the best practice is to make it private class inside the List object.
public class DoubleIntNode {

    DoubleIntNode prev;

    int data;

    DoubleIntNode next;

    public DoubleIntNode(int data){

        this.prev = null;

        this.next = null;

        this.data = data;

    }

    public DoubleIntNode(DoubleIntNode prev, int data, DoubleIntNode next){

        this.prev = prev;

        this.next = next;

        this.data = data;

    }

}