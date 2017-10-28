package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    private Map<String, Boolean> flights() {

        Map<String, Boolean>  mapFlight = new HashMap<>();

        mapFlight.put("Los Angeles", true);
        mapFlight.put("Montreal", false);
        mapFlight.put("San Francisco", false);

        return mapFlight;
    }

    public boolean findFilght(Flight flight) throws RouteNotFoundException {

        Map<String, Boolean>  mapFlight = flights();

        boolean result = false;
        char foundArrival  ='N';
        char findDeparture ='N';


        for(Map.Entry<String, Boolean> entry: mapFlight.entrySet()){
            if (flight.getArrivalAirport().equals(entry.getKey())){
                result =  entry.getValue();
                foundArrival='Y';
            };
            if (flight.getDepartureAirport().equals(entry.getKey())){
                findDeparture='Y';
            };
        }
         if (foundArrival == 'N' || findDeparture =='N') {
            throw new RouteNotFoundException("Airport not found");
         }

        return result;
    }
}
