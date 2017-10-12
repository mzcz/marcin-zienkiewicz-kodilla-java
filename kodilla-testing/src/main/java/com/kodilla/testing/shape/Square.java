package com.kodilla.testing.shape;

public class Square implements Shape {

    private double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public String getShapeName() {
        return getClass().getName();
    }

    @Override
    public double getField() {
        return a*a;
    }
}
