package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHandling;

import java.io.IOException;

public class ExceptionModuleRunner {

    public static void main (String args[]){
        FileReader fileReader = new FileReader ();
        try {
            fileReader.ReadFile();
        } catch (FileReaderException e) {
            System.out.println("Problem with reading file!!!");
        }
    }
}
