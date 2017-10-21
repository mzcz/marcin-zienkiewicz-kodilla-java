package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.OptionalDouble;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage(){
        //Given
        int[] tab = {1,2,3,4,-1,-2,-3,-4,1,2,3,4,5,-15,1,2,3,4,5,50};
        //When
        double averageTabOFIntInt = ArrayOperations.getAverage(tab);
        //Then
        Assert.assertEquals(3.25, averageTabOFIntInt,0.0);
    }
}
