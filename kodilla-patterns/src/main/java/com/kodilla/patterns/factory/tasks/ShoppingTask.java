package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    public static int i_randomize=100;


    public ShoppingTask(String taskName, String whatToBuy, double quantity){
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;

    }

    @Override
    public void executeTask() {

        System.out.println("We have to buy " + quantity + " " + whatToBuy);

    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public Boolean isTaskExecuted() {
       /* Random random = new Random();
        i_randomize = random.nextInt(100);*/

        if (i_randomize>80) {
            return true;
        } else
            return false;
    }
}
