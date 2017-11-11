package com.kodilla.spring.calculator;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculations(){
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double sum = calculator.add(7.20,8.5);
        double sub = calculator.sub(7.20,10.10);
        double mul = calculator.mul(2.0,3.7);
        double div = calculator.div(5.0,2.0);
        double div0 = calculator.div(5.0,0.0);
        //Then
        Assert.assertEquals(15.7,sum,0);
        Assert.assertEquals(-2.9,sub,0.05);
        Assert.assertEquals(7.4, mul,0);
        Assert.assertEquals(2.5, div,0);
        Assert.assertEquals(0.0, div0,0);
    }
}
