//DO NOT REMOVE PACKAGE LINE
//Without this line authograder will not run correctly
//You can comment it while you work on the problem
//When everything works - uncomment and submit!
//package com.gradescope.hw4;

/*Header
/HW4
/Names:
*/
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardsDoubleIntIterator implements Iterator<Integer> {
    private DoubleIntList list; // Reference to the DoubleIntList
    private DoubleIntNode current; // Reference to the current node
    private boolean canRemove; // Flag to indicate if remove can be called

    // Constructor to initialize fields
    public BackwardsDoubleIntIterator(DoubleIntList list) {
        this.list = list; // Store the reference to the list
        this.current = list.getEnd(); // Start from the end node
        this.canRemove = false; // Initially, cannot remove
    }

    @Override
    public boolean hasNext() {
        return current != null; // Check if there is a next element
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements to iterate.");
        }
        int value = current.data; // Get the current node's data
        current = current.prev; // Move to the previous node
        canRemove = true; // Now we can remove
        return value; // Return the current value
    }

    @Override
    public void remove() {
        if (!canRemove) {
            throw new IllegalStateException("Cannot remove before calling next()");
        }

        // Remove the current element (which was just returned by next())
        int removeIndex = (current == null) ? list.size() - 1 : list.indexOf(current.data) + 1;
        list.remove(removeIndex); // Remove the element at the calculated index
        canRemove = false; // Reset the canRemove flag
    }
}
