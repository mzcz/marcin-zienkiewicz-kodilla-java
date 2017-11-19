package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING_TASK = "ShoppingTask";
    public static final String PAINTING_TASK = "PaintingTask";
    public static final String DRIVING_TASK = "DrivingTask";

    public final Task makeShape(final String taskClass) {
        switch (taskClass) {
            case SHOPPING_TASK:
                return new ShoppingTask("buying food", "eggs", 10.00);
            case PAINTING_TASK:
                return new PaintingTask("painting the house", "white", "the wall");
            case DRIVING_TASK:
                return new DrivingTask("trip to Germany", "Berlin", "car");
            default:
                return null;
        }

    }
}
