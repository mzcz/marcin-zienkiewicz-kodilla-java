package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String beautifyText, PoemDecorator poemDecorator) {
        String result = poemDecorator.decorate(beautifyText);
        System.out.println("Text to beautify " + result);
    }
}
