

import bridges.base.ColorGrid;
import bridges.base.Color;

import java.awt.*;

import static bridges.base.NamedSymbol.r;

public class DrawMethods{
    public static void circleDrawing(int r, int xc, int yc, ColorGrid gc, Color color){
		//Let r be radious of the sircle
		//let xc ne x coordinate of the circle
		//let yc be y coordinate of the circle
		//To draw the circle do:
        int x = r;
        int y = 0;
        int error = 0;

        while (x >= y) {		
            //draw  a point with (xc + x, yc + y) coordinates
            //draw  a point with (xc + y, yc + x) coordinates
            //draw a point with (xc + x, yc - y) coordinates
            //draw a point with (xc + y, yc - x) coordinates
            //draw a point with (xc - x, yc + y) coordinates
            //draw a point with (xc - y, yc + x) coordinates
            //draw a point with (xc - x, yc - y) coordinates
            //draw a point with (xc - y, yc - x) coordinates

            y += 1;
            error += 1 + 2 * y;

            if (2 * (error - x) + 1 > 0) {
                x -= 1;
                error += 1 - (2 * x);
            }
        }
	}
	public static void diagonalLineDrawing(int x0, int y0, int x1, int y1, ColorGrid cg, Color color){
		//Let x0 and y0 be start point coordinates 
		//Let x1 and y1 be end point coordinates 
		int xDirection = 0;
        int yDirection = 0;

        int dx = Math.abs(x1 - x0);
        int dy = -Math.abs(y1 - y0);

        int error = dx + dy;
        int error2 = 0;

        if (x0 < x1) {
            xDirection = 1;
        }
        else {
            xDirection = -1;
        }
        if (y0 < y1) {
            yDirection = 1;
        }
        else {
            yDirection = -1;
        }

        int x = x0;
        int y = y0;
		//draw  a point with (x,y) coordinates
        while (x != x1 || y != y1) {
            error2 = error * 2;
            if (x == x1) {
                y += 1;
				//draw  a point with (x,y) coordinates
                continue;
            }

            if (y == y1) {
                x += 1;
                //draw  a point with (x,y) coordinates
                continue;
            }

            if (error2 >= dy) {
                error += dy;
                x += xDirection;
            }
            if (error2 <= dx) {
                error += dx;
                y += yDirection;
            }
            //draw  a point with (x,y) coordinates
        }
    }
}
