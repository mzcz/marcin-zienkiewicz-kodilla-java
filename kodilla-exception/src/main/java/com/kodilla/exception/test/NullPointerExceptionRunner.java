package com.kodilla.exception.test;

public class NullPointerExceptionRunner {

    public static void main(String[] args) {
        FlightSearch flightSearch = new FlightSearch();

        try {
            boolean ifAiportOpen = flightSearch.findFilght(new Flight("San Francisco","New York"));

            System.out.println(ifAiportOpen);

        } catch (RouteNotFoundException e) {
            System.out.println("Arrival/Departure airport doesn't exist in our database!!!");
        }


    }
}
