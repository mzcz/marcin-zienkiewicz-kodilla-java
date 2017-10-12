package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {
        private static int testCounter = 0;


        @BeforeClass
        public static void beforeAllTests() {
            ShapeCollector shapeCollector = shapeCollector = new ShapeCollector();
            System.out.println("This is the beginning of tests.");
        }

        @AfterClass
        public static void afterAllTests() {
            System.out.println("All tests are finished.");
        }

        @Before
        public void beforeEveryTest() {
            testCounter++;
            System.out.println("Preparing to execute test #" + testCounter);
        }

        @Test
        public void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(new Square(10));

            //Then
            Assert.assertEquals(1, shapeCollector.getFigure(0));
        }

        @Test
        public void testRemoveFiguretNotExisting() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            boolean result = shapeCollector.removeFigure(new Circle(10));

            //Then
            Assert.assertFalse(result);
        }
    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(new Triangle(1, 5));

        //When
        boolean result = shapeCollector.removeFigure(new Triangle(1, 5));

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.getFigure(0));
    }
}
