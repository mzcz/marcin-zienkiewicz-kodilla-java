package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    @Autowired
    private Display display;


    public double add(double a, double b) {

        double result = a + b;
        display.displayValue(result);

        return  result;
    }

    public double sub(double a, double b){

        double result = a - b;
        display.displayValue(result);

        return  result;
    }

    public double mul(double a, double b){

        double result = a * b;
        display.displayValue(result);

        return  result;
    }

    public double div(double a, double b) {

        double result = 0;

        try {
            if(b == 0){
                throw new ArithmeticException();
            } else {
                result = a / b;
                display.displayValue(result);
            }
        } catch (ArithmeticException e) {
            System.out.println("Divide by 0 strictly prohibited!" );
        }

        return  result;
    }
}
