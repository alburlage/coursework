//DO NOT REMOVE PACKAGE LINE
//Without this line authograder will not run correctly
//You can comment it while you work on the problem
//When everything works - uncomment and submit!
package com.gradescope.hw6;

/*Header
/HW 6
/Name:
*/

import java.util.NoSuchElementException;
import java.util.Arrays;

public class MinHeap<E extends Comparable<E>> {
    private E[] heap; // The array that holds the heap elements
    private int size; // The current size of the heap (number of elements)

    public MinHeap() {
        this.heap = (E[]) new Comparable[10]; // Initialize the heap array with a default size
        this.size = 0; // Initially, the heap is empty
    }

    // Returns index of left child (existence doesn't matter)
    public int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    // Returns the index of the right child
    public int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    // Returns index of parent (existence doesn't matter)
    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2; // Formula for parent index in a binary heap
    }

    // Returns true if left child exists, false otherwise
    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    // Returns true if the current node has a right child
    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    // Returns true if parent exists, false otherwise
    public boolean hasParent(int index) {
        return index > 0; // Check if parent index is valid (i.e., not negative)
    }

    // Returns element at given index, or throws NoSuchElementException
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException("No element exist at index " + index); // Index out of bounds check
        }
        return heap[index]; // Return the element at the specified index
    }

    // Returns value of the left child, or throws NoSuchElementException
    public E leftChild(int index) {
        if (!hasLeftChild(index)) {
            throw new NoSuchElementException("No left child exist at index " + index); // Check if left child exists
        }
        return heap[getLeftChildIndex(index)]; // Return the left child element
    }

    // Returns value of the right child, or throws NoSuchElementException
    public E rightChild(int index) {
        if (!hasRightChild(index)) {
            throw new NoSuchElementException("No right child exist at index " + index); // Check if right child exists
        }
        return heap[getRightChildIndex(index)]; // Return the right child element
    }

    // Returns value of the parent, or throws NoSuchElementException
    public E parent(int index) {
        if (!hasParent(index)) {
            throw new NoSuchElementException("No parent exist for index " + index); // Check if parent exists
        }
        return heap[getParentIndex(index)]; // Return the parent element
    }

    // Returns the size of the heap (different from capacity)
    public int size() {
        return size; // Return the number of elements currently in the heap
    }

    // Returns true if the heap is empty, false otherwise
    public boolean isEmpty() {
        return size == 0; // Check if the heap has no elements
    }

    // Swaps elements at two indexes
    public void swap(int i1, int i2) {
        if (i1 < 0 || i1 >= size || i2 < 0 || i2 >= size) {
            throw new IndexOutOfBoundsException("Indexes are out of bounds: i1=" + i1 + ", i2=" + i2); // Check if indices are valid
        }
        E temp = heap[i1]; // Store the first element temporarily
        heap[i1] = heap[i2]; // Move the second element to the first position
        heap[i2] = temp; // Move the first element to the second position
    }

    /* Part "Given"
     * Do not change next three methods.
     */
    public void ensureExtraCapacity() {
        if (size == heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2); // If the heap is full, double its size
        }
    }

    public String toString() {
        if (size > 0) {
            String s = "[" + heap[0];
            for (int i = 1; i < size; i++)
                s = s + "," + heap[i];
            return s + "]";
        }
        else {
            return "[]";
        }
        }



    public void printHeap() {
        for (int i = 0; i < heap.length; i++) {
            System.out.println(heap[i]); // Print each element in the heap
        }
    }

    public void setHeap(E[] arr) {
        for( int i=0; i<arr.length; i++){
            heap[i]= arr[i];
        }
        size=arr.length;
    }


    /* Part 2 */

    /* Returns min element of the heap, and throws
     * NoSuchElementException if heap is empty.
     * Note: Does not remove min element!
     */
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }
        return heap[0]; // The root contains the minimum element
    }


    // Rebalance the tree starting from last node in the heap
    public void heapifyUp() {
        int index = size - 1; // Start from the last element
        while (hasParent(index) && parent(index).compareTo(heap[index]) > 0) {
            // If the current element is smaller than its parent, swap them
            swap(index, getParentIndex(index));
            index = getParentIndex(index); // Move up to the parent
        }
    }

    /* This method should add a given element to the heap.
     * Note: Ensure there is space in the array. Use ensureExtraCapacity.
     * Note2: Use heapifyUp to maintain the heap property.
     */
    public void add(E item) {
        ensureExtraCapacity(); // Ensure enough capacity in the heap array
        heap[size] = item; // Place the new item at the end of the heap
        size++; // Increment the heap size
        heapifyUp(); // Rebalance the heap to maintain the heap property
    }


    // Rebalance the tree starting from the root node in the heap.
    public void heapifyDown() {
        int index=0;
        while (hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            //check if the right child exist and smaller
            if (hasRightChild(index)&& rightChild(index).compareTo(leftChild(index))<0){
                smallerChildIndex = getRightChildIndex(index);
            }
            if (heap[index].compareTo(heap[smallerChildIndex])<=0){
                break; // if current node is smaller
            }
            swap(index, smallerChildIndex);//otherwise swap with smaller child
            index = smallerChildIndex; //move index to the child index
        }
    }



    /* This method should remove min element from heap
     * If heap is empty, throws NoSuchElementException
     * Note: Use heapifyDown to maintain the heap property.
     */
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }
        E root = heap[0]; // Save the root value (min element)
        heap[0] = heap[size - 1]; // Replace the root with the last element
        size--; // Decrease the size of the heap
        heapifyDown(); // Rebalance the heap starting from the root
        return root; // Return the min element
    }

}
