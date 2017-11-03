package com.kodilla.good.patterns.challenges.Flight;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Flight {

    private final String aiport;
    private final Set<Flight> fligths = new HashSet<>();

    public Flight(String aiport) {
        this.aiport = aiport;
    }

    public void addFligth(Flight flight) {
        fligths.add(flight);
    }

    public String getAiport() {
        return aiport;
    }

    public Set<Flight> getFligths() {
        return fligths;
    }

    public Set<String> getLocationsOfFlights() {
        return fligths.stream()
                .filter(fligth -> fligth != this)
                .map(fligth -> fligth.getAiport())
                .collect(Collectors.toSet());
    }

    public Set<String> getLocationsOfFlightsOfFlights() {
        return fligths.stream()
                .flatMap(fligth -> fligth.getFligths().stream())
                .filter(fligth -> fligth != this)
                .map(Flight::getAiport)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        return aiport.equals(flight.aiport);
    }

    @Override
    public int hashCode() {
        return aiport.hashCode();
    }

    @Override
    public String toString() {
        return "Flight{" +
                "aiport='" + aiport + '\'' +
                '}';
    }
}

