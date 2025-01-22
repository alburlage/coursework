package com.gradescope.hw2;
import bridges.base.Color;
import bridges.base.ColorGrid;

public class Point extends Mark {
    private int x; // x-coordinate
    private int y;// y-coordinate
    public Point(int x, int y, Color c) {
        // set x, y coordinates and color
        this.x = x;
        this.y=y;
        this.color = c;

    }
    @Override
    public void draw(ColorGrid cg) {
        // set pixel at x,y with correct color
        cg.set(y,x,color); //et the x,y and color to draw

    }
}
