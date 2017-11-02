package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRequest {

    private User user;
    private Suplier suplier;
    private LocalDateTime orderDate;

    public OrderRequest(User user, LocalDateTime orderDate) {
        this.user = user;
        this.orderDate = orderDate;
    }

    public OrderRequest(User user, LocalDateTime orderDate, Suplier suplier) {
        this(user, orderDate);
        this.suplier = suplier;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public Suplier getSuplier() {
        return suplier;
    }

}
