package com.gradescope.hw2;
import bridges.base.Color;
import bridges.base.ColorGrid;

public class VerticalLine extends Mark {
    private int start; // y coordinate line start
    private int end; // y coordinate line end
    private int x; // x coordinate where line is drawn

    public VerticalLine(int start, int end, int x, Color c) {
        this.start = start;
        this.end = end;
        this.x = x;
        this.color = c;
    }

    @Override
    public void draw(ColorGrid cg) {
        //loop from start to end of y coordinate and set pixels at first x position
        for (int y = start; y<= end; y++){
            cg.set(y,x,color);
        }
    }
}
