package com.kodilla.good.patterns.challenges;

import java.util.List;

public class Suplier {
    private String name;
    private List<Product> product;

    public Suplier(String name,List<Product> product) {
        this.name = name;
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Suplier{" +
                "name='" + name + '\'' +
                ", product=" + product +
                '}';
    }
}
