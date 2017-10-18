package com.kodilla.stream.lambda;

public class TestMath implements MathExpression {
    @Override
    public double calculateExpression(double a, double b) {
        return a+b;
    }
}
