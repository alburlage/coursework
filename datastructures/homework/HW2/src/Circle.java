package com.gradescope.hw2;
import bridges.base.Color;
import bridges.base.ColorGrid;

public class Circle extends Mark {
    private int radius;
    private int xcenter; // x-coordinate
    private int ycenter; // y-coordinate

    public Circle(int radius, int xcenter, int ycenter, Color color) {
        this.radius = radius ;
        this.xcenter = xcenter;
        this.ycenter = ycenter;
        this.color = color; // inherited
    }

    @Override
    public void draw(ColorGrid cg) {
        int x = radius;
        int y = 0;
        int error = 0;
/*
        setPixel(cg, xcenter, ycenter + radius); // top of circle
        setPixel(cg, xcenter, ycenter - radius); // bottom
        setPixel(cg, xcenter + ycenter, radius); // right of circle
        setPixel(cg, xcenter - ycenter, radius); //left of circle

        while (x < y) {
            if (d < 0) {
                d = d + 2 * x + 3; // move horizontally
            } else {
                d = d + 2 * (x - y) + 5;// move diagonally
                y--;

            }
            x++;
            drawCirclePoints(cg, x, y);
        }
    }
    private void drawCirclePoints(ColorGrid cg, int x, int y) {
        setPixel(cg, xcenter + x, ycenter + y);
        setPixel(cg, xcenter - x, ycenter - y);
        setPixel(cg, xcenter + x, ycenter + y);
        setPixel(cg, xcenter - x, ycenter - y);
        setPixel(cg, xcenter + y, ycenter + x);
        setPixel(cg, xcenter - y, ycenter - x);
        setPixel(cg, xcenter + y, ycenter + x);
        setPixel(cg, xcenter - y, ycenter - x);
    }

        */
        while (x>= y) {
            //drawing symmetrical points in circle
            setPixel(cg, xcenter + x, ycenter + y);
            setPixel(cg, xcenter + y, ycenter + x);
            setPixel(cg, xcenter + x, ycenter - y);
            setPixel(cg, xcenter + y, ycenter - x);
            setPixel(cg, xcenter - x, ycenter + y);
            setPixel(cg, xcenter - y, ycenter + x);
            setPixel(cg, xcenter - x, ycenter - y);
            setPixel(cg, xcenter - y, ycenter - x);

            y += 1;
            error += 1 + 2 * y;

            if (2* (error - x) + 1 > 0){
                x -= 1;
                error += 1-2*x;
            }

        }
    }

    // helper method for drawing symmetric points
    private void drawCirclePoints(ColorGrid cg, int x, int y){
        setPixel(cg, xcenter + x, ycenter + y);
        setPixel(cg,xcenter - x, ycenter - y);
        setPixel(cg, xcenter + x, ycenter + y);
        setPixel(cg, xcenter - x, ycenter - y);
        setPixel(cg, xcenter + y, ycenter + x);
        setPixel(cg, xcenter - y, ycenter - x);
        setPixel(cg, xcenter + y, ycenter + x);
        setPixel(cg, xcenter - y, ycenter - x);
    }


        private void setPixel (ColorGrid cg,int x, int y){
            if (x >= 0 && x < cg.getWidth() && y >= 0 && y < cg.getHeight()) {
                cg.set(y, x, color);
            }
        }
    }
