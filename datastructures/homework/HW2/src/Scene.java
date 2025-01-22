package com.gradescope.hw2;
import bridges.base.Color;
import bridges.base.ColorGrid;

public class Scene {

    /* Creates a Scene with a maximum capacity of Marks and
	   with a background color.
	   maxMarks: the maximum capacity of Marks
	   backgroundColor: the background color of this Scene
     */
    private int maxMarks; // max number of marks on sscene
    private Color backgroundColor; // background color of scene
    private Mark[] marks; // array to store marks
    private int markCount; //keeps track of marks added

    public Scene(int maxMarks, Color backgroundColor) {
        this.maxMarks = maxMarks;
        this.backgroundColor = backgroundColor;
        this.marks = new Mark[maxMarks]; // initialize array to max ammount of marks
        this.markCount = 0; // mark count starts at zero
    }

    // returns true if the Scene has no room for additional Marks
    public boolean isFull() {
        return markCount>= maxMarks;
    }

    /* Adds a Mark to this Scene. When drawn, the Mark
	   will appear on top of the background and previously added Marks
	   m: the Mark to add
	 */
    public void addMark(Mark m) {
        if (isFull()) {
            throw new IllegalStateException("No room to add more Marks");
        }
        marks[markCount] = m; //add mark to array
        markCount++; // goes to next count of marks
    }


    /*
	Helper method: deletes the Mark at an index.
	If no Marks have been previously deleted, the method
	deletes the ith Mark that was added (0 based).
	i: the index
	 */
    public void deleteMark(int i) {
        if (i >= 0 && i < markCount) {
            for (int j = i; j < markCount - 1; j++) {
                marks[j] = marks[j + 1];
            }
            marks[markCount - 1] = null;  //remove last reference
            markCount--; // decrease ammount of marks
        }
    }

    /*
	Deletes all Marks from this Scene that
	have a given Color
	c: the Color
	 */
    public void deleteMarksByColor(Color c) {
        for (int i = 0; i < markCount; ) { //go through all marks
            if (marks[i].isColor(c)) { // checks if the marks color matches given color
                deleteMark(i);
            } // delete mark if color matches
            else {
                i++; // go to next point if no deletion was executed
            }

        }
    }
	public void draw(ColorGrid cg){
		int width = cg.getWidth(); // get width from grid
		int height = cg.getHeight(); // get height from grid
		//set background color
		for (int y = 0; y<height; y++){
			for (int x = 0; x<width; x++){
				cg.set(y, x, backgroundColor);
			}
		}
		//draw each mark on top of the background
		for (int i=0; i < markCount; i++){
			marks[i].draw(cg); //draw each mark
		}
	}
}
