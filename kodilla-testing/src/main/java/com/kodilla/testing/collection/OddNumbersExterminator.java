package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {

        ArrayList<Integer> oddNumbers = new ArrayList<>();

        if (numbers.isEmpty()) {
            System.out.println("List is empty!!!");
        }
            else {
            for (Integer myOddNumber : numbers) {

                if (myOddNumber % 2 == 0) {

                    oddNumbers.add(myOddNumber);
                }
            }
        }

        return oddNumbers ;
    }
}
