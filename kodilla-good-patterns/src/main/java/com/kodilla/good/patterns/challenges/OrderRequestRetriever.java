package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User("Marcin", "Zienkiewicz");
        LocalDateTime orderdate = LocalDateTime.now();
        return new OrderRequest(user, orderdate);
    }
}