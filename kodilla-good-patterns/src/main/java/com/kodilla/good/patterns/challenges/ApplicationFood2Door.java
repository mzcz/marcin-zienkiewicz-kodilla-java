package com.kodilla.good.patterns.challenges;

public class ApplicationFood2Door {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest1 = orderRequestRetriever.retrieveWithSuplier1();

        ProductOrderService productOrderService1 = new ProductOrderService(new MailService(), new AllegroService(),
                new AllegroOrderRepository());

        productOrderService1.process(orderRequest1);

        OrderRequest orderRequest2 = orderRequestRetriever.retrieveWithSuplier2();

        ProductOrderService productOrderService2 = new ProductOrderService(new MailService(), new AllegroService(),
                new AllegroOrderRepository());

        productOrderService2.process(orderRequest2);

        OrderRequest orderRequest3 = orderRequestRetriever.retrieveWithSuplier3();

        ProductOrderService productOrderService3 = new ProductOrderService(new MailService(), new AllegroService(),
                new AllegroOrderRepository());

        productOrderService3.process(orderRequest3);
    }
}
