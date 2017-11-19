package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {
    private final String taskName;
    private final String where;
    private final String using;
    public static int i_randomize=900;

    public DrivingTask(String taskName, String where, String using){
        this.taskName = taskName;
        this.where = where;
        this.using = using;

    }

    @Override
    public void executeTask() {
        System.out.println("We going to "  + where + " by "+ using);

    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public Boolean isTaskExecuted() {
/*
        Random random = new Random();
        int i = random.nextInt(1000);*/

        if (i_randomize>500) {
            return true;
        } else
            return false;
    }
}
