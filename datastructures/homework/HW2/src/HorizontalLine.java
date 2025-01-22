package com.gradescope.hw2;
import bridges.base.Color;
import bridges.base.ColorGrid;

public class HorizontalLine extends Mark {
    private int start;// x coordinate start
    private int end;// x coordinate end
    private int y; // y coordinate

    public HorizontalLine(int start, int end, int y, Color c) {
        this.start = start;
        this.end = end;
        this.y = y;
        this.color = c;
    }

    @Override
    public void draw(ColorGrid cg) {
        //get width and height of colorgrid
        int width = cg.getWidth();
        int height = cg.getHeight();
        if (y >= 0 && y < height) {
            for (int x = start; x <= end; x++){
                if(x>=0 && x < width){
                    cg.set(y,x,color);
                }
            }
        }
    }
}
