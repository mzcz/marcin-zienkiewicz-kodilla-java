package com.kodilla.patterns2.adapter.company.oldhrsystem;

public class Workers {

    private String[][] workers = {
            {"679238989948","John","Smith"},
            {"629389484094","Ivone","Nowak"},
            {"758978438498","Jessie","Piknman"},
            {"759387894798","Walter","White"},
            {"758372823789","Clara","Lanson"}
    };
    private double[] salaries = {
            4500.00,
            3700.00,
            4350.00,
            9000.00,
            6200.00
    };

    public String getWorker(int n){
        if(n > salaries.length){
            return "";
        }
        return workers[n][0] + ", " + workers[n][1] + ", " + workers[n][2] + ", " + salaries[n];
    }

    public String[][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }

}

