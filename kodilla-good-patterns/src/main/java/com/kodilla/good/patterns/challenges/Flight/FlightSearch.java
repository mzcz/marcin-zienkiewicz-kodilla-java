package com.kodilla.good.patterns.challenges.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightSearch {

    public static final String WROCLAW = "Wrocław";
    public static final String KRAKOW = "Kraków";
    public static final String WARSZAWA = "Warszawa";
    public static final String LODZ = "Łódź";
    public static final String GDANSK = "Gdańsk";
    public static final String KATOWICE = "Katowice";
    public static final String POZNAN = "Poznań";
    public static final String RADOM = "Radom";
    public static final String OLSZTYN = "Olsztyn";


    public Flight aiportWroc = new Flight(WROCLAW);
    public Flight aiportKrak = new Flight(KRAKOW);
    public Flight aiportWars = new Flight(WARSZAWA);
    public Flight aiportLodz = new Flight(LODZ);
    public Flight aiportGda  = new Flight(GDANSK);
    public Flight aiportKat  = new Flight(KATOWICE);
    public Flight aiportPoz  = new Flight(POZNAN);
    public Flight aiportRad  = new Flight(RADOM);
    public Flight aiportOlsz  = new Flight(OLSZTYN);

    private void prepareData(){

        //From Gdańsk
        aiportGda.addFligth(aiportWroc);
        aiportGda.addFligth(aiportKrak);
        aiportGda.addFligth(aiportGda);
        aiportGda.addFligth(aiportWars);
        aiportGda.addFligth(aiportOlsz);

        //From Warszawa
        aiportWars.addFligth(aiportWroc);
        aiportWars.addFligth(aiportKrak);
        aiportWars.addFligth(aiportKat);
        aiportWars.addFligth(aiportRad);

        //From Kraków
        aiportKrak.addFligth(aiportWroc);
        aiportKrak.addFligth(aiportKat);
        aiportKrak.addFligth(aiportLodz);

        //From Wrocław
        aiportWroc.addFligth(aiportGda);
        aiportWroc.addFligth(aiportPoz);
        aiportWroc.addFligth(aiportRad);
        aiportWroc.addFligth(aiportWroc);

        //From Radom
        aiportRad.addFligth(aiportOlsz);
        aiportRad.addFligth(aiportWroc);

    }

    private List<Flight> aiportList() {

        List<Flight> allAiports = new ArrayList<>();

        allAiports.add(aiportWroc);
        allAiports.add(aiportKrak);
        allAiports.add(aiportWars);
        allAiports.add(aiportLodz);
        allAiports.add(aiportGda);
        allAiports.add(aiportKat);
        allAiports.add(aiportPoz);
        allAiports.add(aiportRad);
        allAiports.add(aiportOlsz);

        return allAiports;
    }

    public void searchFligthFrom(Flight fligh){
        System.out.println("1.Znalezienie wszystkich lotów z podanego miasta");

        prepareData();
/*
        System.out.println("  All flights direct from " + fligh.getAiport() + " " +  fligh.getLocationsOfFlights().size());

        for(String flithsFrom: fligh.getLocationsOfFlights() ) {
            System.out.println(fligh.getAiport() + " -> " + flithsFrom);
        }
        System.out.println("  All flights direct/inderict from " + fligh.getAiport() + " " +  fligh.getLocationsOfFlightsOfFlights().size());

        for(String flithsFrom: fligh.getLocationsOfFlightsOfFlights() ) {
            System.out.println(fligh.getAiport() + " -> " + flithsFrom);   !!!!!! Nie pokazuje Olsztyna jak wartością jest Radom :-)
        }*/

        List<Flight> allAiports = aiportList();

        System.out.println("  All flights  from " + fligh.getAiport());
        for (Flight timeTable:allAiports ){
//!!!!!! Nie pokazuje Olsztyna jak wartością jest Radom :-) dlatego uzyłem koniunkcji
            if (fligh.getLocationsOfFlights().contains(timeTable.getAiport()) == true ||
            fligh.getLocationsOfFlightsOfFlights().contains(timeTable.getAiport()) == true)
            {
                System.out.println(fligh.getAiport() +  " -> " + timeTable.getAiport());
            };

        }

        System.out.println("-----------------");

    }

    public void searchFlightsTo(String flight){
        System.out.println("2.Znalezienie wszystkich lotów do danego miasta");

        prepareData();
        List<Flight> allAiports = aiportList();

        for (Flight timeTable:allAiports ){

            if (timeTable.getLocationsOfFlights().contains(flight) == true){
                System.out.println(timeTable.getAiport() +  " -> " + flight);
            };

        }
        System.out.println("-----------------");

    }

    public void searchFligthIndirect(Flight fligh, Flight inderictFlight){
        System.out.println("3.Znalezienie lotów poprzez inne miasto np. lot z Gdańska przez Kraków do Wrocławia");

        prepareData();
        List<Flight> allAiports = aiportList();

        System.out.println("Indirect flights from " + fligh.getAiport());
        System.out.println();
        for(String flithsFrom: fligh.getLocationsOfFlights() ){
            for (Flight aiports:  allAiports) {
                if (flithsFrom.equals(aiports.getAiport()) && flithsFrom.equals(inderictFlight.getAiport())) {
                    for (String flithsFrom2 : aiports.getLocationsOfFlights()) {
                        System.out.println(fligh.getAiport() + " -> " + flithsFrom + " -> " + flithsFrom2);
                    }

                }
            }
        }

        System.out.println("-----------------");
    }

}
