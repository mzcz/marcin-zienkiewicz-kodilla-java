package com.kodilla.good.patterns.challenges.Flight;

public class FlightsRunner {
    public static void main(String[] args) {

        FlightSearch flightSearch = new FlightSearch();

        //1.Znalezienie wszystkich lotów z podanego miasta
        flightSearch.searchFligthFrom(flightSearch.aiportGda);
        flightSearch.searchFligthFrom(flightSearch.aiportRad);

        //2.Znalezienie wszystkich lotów z podanego miasta
        flightSearch.searchFlightsTo("Kraków");

        //3.Znalezienie lotów poprzez inne miasto np. lot z Gdańska przez Kraków do Wrocławia
        flightSearch.searchFligthIndirect(flightSearch.aiportGda, flightSearch.aiportKrak);

    }
}
