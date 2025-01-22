//DO NOT REMOVE PACKAGE LINE
//Without this line autograder will not run correctly.
//You can comment it while you work on the problem.
//When everything works - uncomment and submit!
//package com.gradescope.hw3;

public class DoubleIntList implements IntList{
    //Part 1
    //Add appropriate instance variables/fields. In this case, encapsulation is
    //adhered to and accessor/mutator methods must be written.
    private DoubleIntNode front; // reference to front node
    private DoubleIntNode end;// reference to end node
    private int size; // num of nodes in list

    //add constructor
    public DoubleIntList(){ // intitializes an empty list
        this.front = null;
        this.end = null;
        this.size = 0;

    }
    public int size(){
        return this.size;}
    public DoubleIntNode getFront(){
        return this.front;}
    public DoubleIntNode getEnd(){
        return this.end;}

    //Part 2
    //uncomment when directed to, checkIndex method is used in add and remove
    public void checkIndex(int index) {
        //index should be between 0 and size-1
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("index: " + index + "and size: " + this.size);
        }
    }
    public void add(int value) {
        //This method adds value to the end of the linked list.
        //You are not allowed to use any extra space of O(n) size.
        //You can, and should, create helper methods to help with this method.
        DoubleIntNode newNode = new DoubleIntNode(value); // creates new node
        if (this.front == null){
            this.front = newNode;
            this.end = newNode;
        } else{
            this.end.next = newNode; // add new node behind end
            newNode.prev = this.end;
            this.end = newNode;// update pointer to new node
        }
        this.size++;
    }

    public void add(int index, int value) {
        //This method adds value to the index slot of the linked list.
        //You are not allowed to use any extra space of O(n) size.
        //You can, and should, create helper methods to help with this method.
        if (index == this.size){
            add(value);
            return;
        }
        checkIndex(index); // checks if index is valid for insertion

        DoubleIntNode newNode = new DoubleIntNode(value); // creates new node with the value

        if (index == 0){//insertion at the fornt
            newNode.next = this.front;
            this.front.prev = newNode;
            this.front = newNode;
        }else{
            DoubleIntNode current = this.front;

            for (int i = 0; i < index - 1; i++){
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev= current;
            if(current.next != null){
                current.next.prev = newNode;
            }
            current.next=newNode;
        }
        this.size++;
    }

    //Part 3
    public String toString(){
        //Write a method to return correct string representation: [1,2,3].
        //Be sure to get the format of the string correct.
        if(this.front == null){// if this list is empty return empty bracket
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("["); // start with open bracket
        DoubleIntNode current = this.front; // start traversing form front
        while(current != null){
            result.append(current.data);
            if (current.next !=null){
                result.append(",");
            }
            current = current.next;
        }

        result.append("]");
        return result.toString(); // return final string representation
    }

    //Part 4
    public void set(int index, int value){
        //You are not allowed to create any new nodes.
        checkIndex(index); //ensure index is valid
        DoubleIntNode current = this.front;
        for (int i=0; i < index; i++){
            current = current.next;
        }
    }

    public int get(int index){
        //Return value of the element at index.
        //You must ensure the index is valid.
        checkIndex(index);
        DoubleIntNode current = this.front;
        for (int i=0; i < index;i++){
            current = current.next;
        }
        return current.data;
    }

    public int indexOf(int value){
        //If the value is in the list, return the index of the first occurrence,
        //otherwise return -1.
            DoubleIntNode current = front; // Start from the head of the list
            int index = 0; // Initialize the index counter

            while (current != null) { // Traverse the list
                if (current.data == value) { // Check if the current node's data matches the value
                    return index; // Return the index if a match is found
                }
                current = current.next; // Move to the next node
                index++; // Increment the index
            }

            return -1; // Return -1 if the value was not found
        }



    public boolean isEmpty(){
        //Return true if the list is empty, false otherwise.

            // Return true if the list is empty (size is 0 or head is null)
            return size == 0; // or you could also check if head == null


    }

    //Part 5
    public void remove(int index){
        //Remove the element at slot index from the list.
        //You are not allowed to use any extra space of O(n) size.
        //You can't create any new nodes, i.e. the "new" key word is not allowed.
        //You can and should create helpers.
        checkIndex(index);
        if (index == 0){
            this.front = this.front.next;
            if (this.front != null){
                this.front.prev = null;
            } else {
                this.end = null;
            }
        } else if (index == this.size -1){
            this.end = this.end.prev;
            this.end.next = null;
        } else{
            DoubleIntNode current = this.front;
            for (int i =0; i<index; i++){
                current =current.next;
            }
            current.prev.next = current.next;
            current.next.prev=current.prev;
        }
        this.size--;
    }

    //Part 6
    public void sort(){
        //Use selection sort to put your list in order.
        //After the method is complete, your list should be sorted.
        //You are not allowed to use any extra space of O(n) size.
        //You can't create any new nodes, i.e. the "new" key word is not allowed.
        //You can and should create helpers.
        //You are not allowed to use add or remove in this method.
        if (this.size <2){
            return;
        }
        DoubleIntNode current = this.front;
        for (int i =0; i < this.size-1; i++){
            DoubleIntNode minNode = current;
            DoubleIntNode searchNode = current.next;
            while(searchNode != null){
                if (searchNode.data < minNode.data){
                    minNode= searchNode;
                }
                searchNode=searchNode.next;
            }
            if (minNode != current){
                int temp = current.data;
                current.data = minNode.data;
                minNode.data = temp;
            }
            current = current.next;
        }
    }
}
