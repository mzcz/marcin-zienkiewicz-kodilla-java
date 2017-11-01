package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class AllegroService implements OrderService {
    @Override
    public boolean order(User user, LocalDateTime orderDate) {
        System.out.println(user + " ordered " + " game " + orderDate);
        return true;
    }
}
