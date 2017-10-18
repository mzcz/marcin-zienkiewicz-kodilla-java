package com.kodilla.stream;



import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

import static jdk.nashorn.internal.objects.NativeString.substr;
import static jdk.nashorn.internal.objects.NativeString.toLowerCase;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;


public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");
/*
        Processor processor = new Processor();
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);*/

        Processor processor = new Processor();
        Executor codeToExecute = () -> System.out.println("This is an example text.");
        processor.execute(codeToExecute);

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
        TestMath testMath = new TestMath();
        expressionExecutor.executeExpression(10, 5, testMath);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        //Task 1
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Kodilla",(beautifyText) -> "ABC" + beautifyText);
        poemBeautifier.beautify("Kodilla",(beautifyText) -> beautifyText + "ABC");
        poemBeautifier.beautify("Kodilla",(beautifyText) -> "ABC" + beautifyText + "ABC");
        poemBeautifier.beautify("Kodilla",(beautifyText) -> toUpperCase(beautifyText));

        poemBeautifier.beautify("Kodilla",(beautifyText) -> toLowerCase(beautifyText));
        poemBeautifier.beautify("Kodilla",(beautifyText) -> "C" + substr(beautifyText,1,beautifyText.length()));

    }
}

