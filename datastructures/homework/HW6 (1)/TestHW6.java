package com.gradescope.hw6;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class TestHW6 {

    @Test
    public void test1Part1(){
        Integer[] arr = {5,20,30,50,35,75,40,65,55,45};
        MinHeap<Integer> h = new MinHeap<Integer>();
        assertTrue(h.isEmpty());
        h.setHeap(arr);
        //System.out.println(h);
        assertTrue(h.leftChild(3)==65);
        assertTrue(h.rightChild(3)==55);
        assertTrue(h.parent(3)==20);
        assertTrue(!h.hasParent(0));
        assertTrue(!h.hasLeftChild(5));
        assertTrue(!h.hasRightChild(4));
        assertTrue(h.size()==10);
        assertTrue(!h.isEmpty());
        h.swap(2,8);
        String exp= "[5,20,55,50,35,75,40,65,30,45]";
        assertEquals(exp,h.toString());
    }
    
    @Test
    public void test2Part1(){
        String[] arr = {"apple","orange","banana","peach","strawberry","blueberry","melon","plum","watermelon","raspberry"};
        MinHeap<String> h = new MinHeap<String>();
        assertTrue(h.isEmpty());
        h.setHeap(arr);
        //System.out.println(h);
        assertTrue(h.leftChild(2)=="blueberry");
        assertTrue(h.rightChild(1)=="strawberry");
        assertTrue(h.parent(6)=="banana");
        assertTrue(h.hasParent(8));
        assertTrue(h.hasLeftChild(4));
        assertTrue(h.hasRightChild(0));
        assertTrue(h.size()==10);
        assertTrue(!h.isEmpty());
        h.swap(0,1);
        String exp= "[orange,apple,banana,peach,strawberry,blueberry,melon,plum,watermelon,raspberry]";
        assertEquals(exp,h.toString());
    }

    @Test
    public void test3Part1(){
        Double[] arr = {4.5,7.8,6.15,8.9,9.1,11.45};
        MinHeap<Double> h = new MinHeap<Double>();
        assertTrue(h.isEmpty());
        h.setHeap(arr);
        //System.out.println(h);
        assertTrue(h.leftChild(1)==8.9);
        assertTrue(h.rightChild(1)==9.1);
        assertTrue(h.parent(2)==4.5);
        assertTrue(!h.hasParent(0));
        assertTrue(h.hasLeftChild(2));
        assertTrue(h.hasRightChild(0));
        assertTrue(h.size()==6);
        assertTrue(!h.isEmpty());
        h.swap(1,5);
        String exp= "[4.5,11.45,6.15,8.9,9.1,7.8]";
        assertEquals(exp,h.toString());
    }

    @Test
    public void testPeek1(){
        MinHeap<Integer>  h = new MinHeap<>();
        Integer[] numbers = {3,1,7,11,2,15,8,4,1,5,21,13};
        Integer[] expected = {1,1,7,2,3,13,8,11,4,5,21,15,};
        for (int i=0; i< numbers.length; i++)
            h.add(numbers[i]);
        assertEquals(expected[0], h.peek());
    }

    @Test
    public void testPeek2(){
        MinHeap<String> h2 = new MinHeap<String>();
        String[] str = {"C", "D", "A", "F", "A", "Z", "M"};
        String[] expected = {"A", "A", "C", "F", "D", "Z", "M"};

        for (int i=0; i<str.length; i++)
            h2.add(str[i]);

        assertEquals(expected[0], h2.peek());
    }

    @Test
    public void testAdd1() {
        MinHeap<Integer>  h = new MinHeap<>();
        Integer[] numbers = {3,1,7,11,2,15,8,4,1,5,21,13};
        Integer[] expected = {1,1,7,2,3,13,8,11,4,5,21,15,};
        for (int i=0; i< numbers.length; i++)
            h.add(numbers[i]);
        for (int i=0; i<numbers.length; i++)
            assertEquals(h.get(i), expected[i]);

    }

    @Test
    public void testAdd2() {
        MinHeap<String> h = new MinHeap<String>();
        String[] str = {"C", "D", "A", "F", "A", "Z", "M"};
        String[] expected = {"A", "A", "C", "F", "D", "Z", "M"};
        for (int i=0; i< str.length; i++)
            h.add(str[i]);
        // Testing for the correct order of elements in the minHeapInt
        for (int i=0; i<str.length; i++)
            assertEquals(h.get(i), expected[i]);
    }

    @Test
    public void testRemove1(){
        MinHeap<Integer>  h = new MinHeap<>();
        Integer[] numbers = {3,1,7,11,2,15,8,4,1,5,21,13};
        Integer[] sortedNumbers = {1,1,2,3,4,5,7,8,11,13,15,21};
        // Check if the elements are added in correct order
        for (int i=0; i< numbers.length; i++)
            h.add(numbers[i]);

        for (int i=0; i<numbers.length; i++)
            assertEquals(sortedNumbers[i], h.remove());
    }

    @Test
    public void testRemove2(){
        MinHeap<String> h = new MinHeap<String>();
        String[] str = {"C", "D", "A", "F", "A", "Z", "M"};
        String[] expected = {"A", "A", "C", "D", "F", "M", "Z"};
        // Check if the elements are added in correct order
        for (int i=0; i< str.length; i++)
            h.add(str[i]);

        for (int i=0; i<str.length; i++)
            assertEquals(expected[i], h.remove());
    }






}
