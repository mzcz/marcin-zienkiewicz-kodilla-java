package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {

    private final String taskName;
    private final String color;
    private final String whatToPaint;
    public static int i_randomize=4;

    public PaintingTask(String taskName, String color, String whatToPaint){
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask() {
        System.out.println(whatToPaint + " should be paint " + color);
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public Boolean isTaskExecuted() {
/*
        Random random = new Random();
        int i = random.nextInt(10);*/

        if (i_randomize>5) {
            return true;
        } else
        return false;
    }
}
