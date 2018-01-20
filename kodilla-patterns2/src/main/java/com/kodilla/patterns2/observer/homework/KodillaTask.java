package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class KodillaTask implements Observable {

    private final List<Observer> mentors;
    private final List<String> tasks;
    private final String name;

    public KodillaTask(String name) {
        this.mentors = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.name = name;
    }

    public void addTask(String task){
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer mentor) {
        mentors.add(mentor);
    }

    @Override
    public void notifyObservers() {
        for (Observer mentor: mentors){
            mentor.update(this);
        }
    }

    public List<String> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }
}
