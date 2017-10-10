package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

    // tu umieść kolejny test ->
           System.out.println("Test - pierwszy test jednostkowy:");

        Calculator calculator = new Calculator();

        Integer sumOFEelemets = calculator.add(24, 11);

        if (sumOFEelemets.equals(35)){
            System.out.println("Sum elements " + sumOFEelemets + " test OK");
        } else {
            System.out.println("Error, sum of elements different that " + sumOFEelemets + " !!!");
        }

        Integer subtractOFEelemets = calculator.subtract(2, 11);

        if (subtractOFEelemets.equals(-9)){
            System.out.println("Subtract elements " + subtractOFEelemets + " test OK");
        } else {
            System.out.println("Error, subtract of elements different that " + subtractOFEelemets + " !!!");
        }

    }
}