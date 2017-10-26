package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    public void ReadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());

        try (Stream<String> fileLines = Files.lines(Paths.get(file.getPath()))){

            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oh no! somethings went wrong!!!" + e);
        } finally {

            System.out.println("I am gonna by  always ...!!!");
        }

    }
}
