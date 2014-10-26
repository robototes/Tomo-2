package com.shsrobotics.tomo2;

public class Location {

    public double x;
    public double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void subtract(Location a) {
        this.x -= a.x;
        this.y -= a.y;
    }

    public void add(Location a) {
        this.x += a.x;
        this.y += a.y;
    }
}
