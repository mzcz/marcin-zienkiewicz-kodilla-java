package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class AllegroOrderRepository implements OrderRepository {
    @Override
    public boolean createOrder(User user, LocalDateTime orderDate) {
        System.out.println(user + " saved in database at " + orderDate );
        return true;
    }

    @Override
    public boolean createOrderFromSuplier(User user, LocalDateTime orderDate, Suplier suplier) {
        System.out.println(user + " ordered  product  from " + suplier + " saved in database at " + orderDate);
        System.out.println("------------------------------------------------------------------------------------------");
        return true;
    }
}
