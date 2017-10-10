package com.kodilla.testing.calculator;

public class Calculator {

    private int a, b;

    public Calculator(){

    }
    public Calculator(final int a, final int b){
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int add(int a, int b){
        return a + b;
    }

    public int subtract(int a, int b){
        return a - b;
    }

}
