package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaskFactoryTestSuite {
    private static int i;

    @Before
    public void test(){
        i++;
        System.out.println("#Test number " + i);
    }

    @Test
    public void testFactoryShopping() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.makeShape(TaskFactory.SHOPPING_TASK);
        shopping.executeTask();

        boolean isExecuted = shopping.isTaskExecuted();
        System.out.println(isExecuted);
        //Then
        Assert.assertEquals("buying food", shopping.getTaskName());
        Assert.assertEquals(true, isExecuted);
    }

    @Test
    public void testFactoryPainting() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task painting = factory.makeShape(TaskFactory.PAINTING_TASK);
        painting.executeTask();

        boolean isExecuted = painting.isTaskExecuted();
        System.out.println(isExecuted);
        //Then
        Assert.assertEquals("painting the house", painting.getTaskName());
        Assert.assertEquals(false, isExecuted);
    }

    @Test
    public void testFactoryDriving() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task driving = factory.makeShape(TaskFactory.DRIVING_TASK);
        driving.executeTask();

        boolean isExecuted = driving.isTaskExecuted();
        System.out.println(isExecuted);
        //Then
        Assert.assertEquals("trip to Germany", driving.getTaskName());
        Assert.assertEquals(true, isExecuted);
    }
}
