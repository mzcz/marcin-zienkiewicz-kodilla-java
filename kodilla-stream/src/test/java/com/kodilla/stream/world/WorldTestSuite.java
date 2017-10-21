package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        World world = new World();

        Continent europe = new Continent();
        world.addContinent(europe);

        Country poland  = new Country("Poland",new BigDecimal("40000000")) ;
        Country germany  = new Country("Germany",new BigDecimal("80000000")) ;

        europe.addCountry(poland);
        europe.addCountry(germany);

        Continent asia = new Continent();
        world.addContinent(asia);

        Country russia  = new Country("Russia",new BigDecimal("120000000")) ;
        Country china  = new Country("China",new BigDecimal("1500000000")) ;
        Country india  = new Country("India",new BigDecimal("1000000000")) ;

        asia.addCountry(russia);
        asia.addCountry(china);
        asia.addCountry(india);

        Continent northAmerica = new Continent();
        world.addContinent(northAmerica);

        Country usa  = new Country("Russia",new BigDecimal("323000000")) ;
        Country canada  = new Country("China",new BigDecimal("36000000")) ;

        northAmerica.addCountry(usa);
        northAmerica.addCountry(canada);

        //When
        BigDecimal totalPeople =  world.getPeopleQuantity();

        //Then
        BigDecimal expectedTotalPeopleQuantity = new BigDecimal("3099000000");
        Assert.assertEquals(expectedTotalPeopleQuantity, totalPeople);
    }
}
