package com.kodilla.stream.world;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class Continent {

    private final Set<Country> countries = new HashSet<>();

    public void addCountry(Country country){
        countries.add(country);
    }

    public Set<Country> getCountries() {
        return countries;
    }
}
