package com.company;

import java.awt.*;

public class RegularPolygon extends Polygon
{
    private int x;
    private int y;
    private int radius;
    private  int sides;

    public RegularPolygon(int x0, int y0, int radius, int sides) {
        this.x = x0;
        this.y = y0;
        this.radius = radius;
        this.sides = sides;
        double alpha = 2 * Math.PI / sides;
        for (int i = 0; i < sides; i++) {
            double x = x0 + radius * Math.cos(alpha * i);
            double y = y0 + radius * Math.sin(alpha * i);
            this.addPoint((int) x, (int) y);
        }
    }
    public int getX()
    {
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getRadius(){
        return this.radius;
    }
    public int getSides(){
        return this.sides;
    }
}
