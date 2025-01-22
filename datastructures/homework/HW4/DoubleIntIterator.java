//DO NOT REMOVE PACKAGE LINE
//Without this line authograder will not run correctly
//You can comment it while you work on the problem
//When everything works - uncomment and submit!
//package com.gradescope.hw4;


/*Header
/HW4
/Names:Addisyn Burlage
*/
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleIntIterator implements Iterator<Integer> {
    private DoubleIntNode current; // Reference to the current node
    private DoubleIntList list; // Reference to the list
    private int index; // Track the current index

    // Constructor that initializes the iterator to the front of the list
    public DoubleIntIterator(DoubleIntList list) {
        this.list = list; // Store the reference to the list
        this.current = list.getFront(); // Start from the front node
        this.index = 0; // Initialize index
    }

    // Returns true if there is a next element
    @Override
    public boolean hasNext() {
        return current != null; // Check if current node is not null
    }

    // Returns the next element in the iteration
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements to iterate.");
        }
        int value = current.data; // Get the current node's data
        current = current.next; // Move to the next node
        index++; // Increment the index
        return value; // Return the current value
    }

    // Removes the last element returned by this iterator
    @Override

    public void remove() {
        if (index == 0) {
            throw new IllegalStateException("Cannot remove before calling next()");
        }

        // Remove the element at index - 1 (the last element returned by next())
        list.remove(index - 1);
        index--; // Decrement the index since we removed the current element

        // Adjust current to point to the correct node
        if (index == 0) {
            current = list.getFront(); // Reset to front if at the beginning
        } else {
            // Traverse to the correct node
            current = list.getFront(); // Start from the front again
            for (int i = 0; i < index; i++) {
                current = current.next; // Move to the previous node
            }
        }
    }

}
