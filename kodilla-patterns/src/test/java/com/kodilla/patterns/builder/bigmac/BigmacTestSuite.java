package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BigmacTestSuite {
    private static int i;

    @Before
    public void test(){
        i++;
        System.out.println("#Test number " + i);
    }

    @Test
    public void testBurgerWithAllIngredients() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .withRoll("roll with sesame")
                .withBurgers(2)
                .withSauce("barbecue")
                .withIngredients("salat")
                .withIngredients("onion")
                .withIngredients("cucumber")
                .withIngredients("chili")
                .withIngredients("mushrooms")
                .withIngredients("cheese")
                .build();
        System.out.println(bigmac);

        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        Assert.assertEquals(6, howManyIngredients);
    }

    @Test
    public void testBurgerWithNoIngredients() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .withRoll("roll without sesame")
                .withBurgers(1)
                .withSauce("standard")
                .build();
        System.out.println(bigmac);

        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        Assert.assertEquals(0, howManyIngredients);
    }
}
