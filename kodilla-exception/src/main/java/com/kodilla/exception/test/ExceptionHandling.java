package com.kodilla.exception.test;

import com.sun.org.apache.xpath.internal.SourceTree;

public class ExceptionHandling {

    public static void main (String args[]){
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            String result = secondChallenge.probablyIWillThrowException(1.5,1.5);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Problem with reading values!!!");
        } finally {
            System.out.println("Block finished");
        }
    }
}
