package com.gradescope.hw2;
import bridges.base.Color;
import bridges.base.ColorGrid;

public class DiagonalLine extends Mark {
    private int x0; // x coordinate of start point
    private int y0; // y coordinate of start point
    private int x1;// x coordinate of end point
    private int y1;// y coordinate of end point

    //constructor
    public DiagonalLine(int x0, int y0, int x1, int y1, Color color) {
        this.x0 = x0;
        this.y0= y0;
        this.x1 = x1;
        this.y1 = y1;
        this.color = color;
    }

    @Override
    public void draw(ColorGrid cg) {
        int xDir = 0;
        int yDir = 0;
        int dx = Math.abs(x1-x0);
        int dy = -Math.abs(y1-y0);
        int error = dx + dy;
        int error2 = 0;




        //loop to draw line from (x1,x2) to (x2,y2)

        /*while(true){
            setPixel (cg, x1, y1);
            if (x1 == x2 && y1 == y2) break; //exit loop if reached end point
            int error2 = error *2;
            if (error2 < dy){
                error += dy;
                x1 += sx;
            }
            if (error2 < dx){
                error += dx;
                y1 += sy;
            }

        }
*/
        if(x0<x1){
            xDir = 1;
        }else {
            xDir = -1;
        }

        if(y0<y1){
            yDir = 1;
        } else {
            yDir = -1;
        }

        int x = x0;
        int y = y0;

        //draw initial point at (x1, y1)
        setPixel(cg, x, y);

        while(x != x1 || y != y1){
            error2 = error * 2;

            if (error2>= dy){
                error += dy;
                x += xDir;
            }
            if (error2 <=dx){
                error += dx;
                y+= yDir;
            }

            // draw the point with new coordinates
            setPixel(cg, x, y);
        }

    }
    private void setPixel(ColorGrid cg, int x, int y){
        if (x>= 0 && x < cg.getWidth() && y >= 0 && y < cg.getHeight()){
            cg.set(y, x, color);
        }
    }
}
