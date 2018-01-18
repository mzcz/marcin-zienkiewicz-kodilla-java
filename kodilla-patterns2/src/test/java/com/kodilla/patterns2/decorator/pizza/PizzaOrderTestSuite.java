package com.kodilla.patterns2.decorator.pizza;

import com.kodilla.patterns2.decorator.MushroomDecorator;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("ciasto i sos pomidorowy z serem", description);
    }

    @Test
    public void testPizzaOrderWithCheeseGetCost(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new CheeseDecorator(pizzaOrder);
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(20), calculatedCost);
    }

    @Test
    public void testPizzaOrderWithCheeseDescription(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new CheeseDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("ciasto i sos pomidorowy z serem + dodatkowy ser", description);
    }

    @Test
    public void testPizzaOrderWithCheeseDoubleOlivesGetCost(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new CheeseDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(24), calculatedCost);
    }

    @Test
    public void testPizzaOrderWithCheeseDoubleOlivesDescription(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new CheeseDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("ciasto i sos pomidorowy z serem + dodatkowy ser + oliwki + oliwki", description);
    }

    @Test
    public void testPizzaOrderWithMushroomOlivesGetCost(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new MushroomDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        //When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(21), calculatedCost);
    }

    @Test
    public void testPizzaOrderWithMushroomOlivesDescription(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new MushroomDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("ciasto i sos pomidorowy z serem + pieczarki + oliwki", description);
    }
}
