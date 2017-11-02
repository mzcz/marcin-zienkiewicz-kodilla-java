package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User("Marcin", "Zienkiewicz");
        LocalDateTime orderdate = now();
        return new OrderRequest(user, orderdate);
    }

    public OrderRequest retrieveWithSuplier1() {
        User user = new User("Adam", "Nowak");
        LocalDateTime orderdate = now();

        List<Product> products = new ArrayList<>();
        products.add(new Product("frites",2));
        products.add(new Product("chips",3));

        Suplier suplier = new Suplier("ExtraFoodShop",products);

        return new OrderRequest(user, orderdate, suplier);
    }

    public OrderRequest retrieveWithSuplier2() {
        User user = new User("Jan", "Kowalski");
        LocalDateTime orderdate = now();

        List<Product> products = new ArrayList<>();
        products.add(new Product("vegan soup",5));
        products.add(new Product("carrot juice",4));
        products.add(new Product("ice cream",3));

        Suplier suplier = new Suplier("HealthyShop",products);
        return new OrderRequest(user, orderdate, suplier);
    }

    public OrderRequest retrieveWithSuplier3() {
        User user = new User("Marcin", "Zienkiewicz");
        LocalDateTime orderdate = now();

        List<Product> products = new ArrayList<>();
        products.add(new Product("groats",1));

        Suplier suplier = new Suplier("GlutenFreeShop",products);
        return new OrderRequest(user, orderdate, suplier);
    }
}