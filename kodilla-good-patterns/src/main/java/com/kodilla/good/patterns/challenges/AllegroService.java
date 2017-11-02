package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class AllegroService implements OrderService {
    @Override
    public boolean order(User user, LocalDateTime orderDate) {
        System.out.println(user + " ordered " + " game " + orderDate);
        return true;
    }

    @Override
    public boolean orderProductFromSuplier(User user, LocalDateTime orderDate, Suplier suplier) {

        if (suplier.getName().equals("ExtraFoodShop")) {

            System.out.println(user + " ordered  product  from " + suplier + " at " + orderDate + " disqcount after order 5 times");

        } else if (suplier.getName().equals("HealthyShop")) {

            System.out.println(user + " ordered  product  from "  + suplier + " at " + orderDate + " disqcount after order 15 times");

        } else if (suplier.getName().equals("GlutenFreeShop")) {

            System.out.println(user + " ordered  product  from "  + suplier + " at " + orderDate + " disqcount after order 10 times");

        } else {

            System.out.println(user + " ordered  product  from " + suplier + " at " + orderDate);
        }
        return true;
    }
}
