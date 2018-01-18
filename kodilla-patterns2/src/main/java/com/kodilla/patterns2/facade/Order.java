package com.kodilla.patterns2.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private ProductService produktService;
    private final List<Item> items = new ArrayList<>();
    private final Long orderId;
    private final Long userId;
    private boolean isPaid;
    private boolean isVerified;
    private boolean isSubmitted;


    public Order(Long orderId, Long userId,ProductService produktService) {
        this.orderId = orderId;
        this.userId = userId;
        this.produktService = produktService;
    }

    public BigDecimal calculateValue(){

        BigDecimal sum = BigDecimal.ZERO;
        for(Item item: items){
            sum = sum.add(produktService.getPrice(item.getProductId()))
                    .multiply(new BigDecimal(item.getQty()));
        }
        return sum;
    }

    public ProductService getProduktService() {
        return produktService;
    }

    public List<Item> getItems() {
        return items;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public void setProduktService(ProductService produktService) {
        this.produktService = produktService;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }
}
