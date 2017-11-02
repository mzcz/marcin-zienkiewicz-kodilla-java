package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public ProductOrderService(final InformationService informationService,
                               final OrderService orderService,
                               final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto processOrder(final OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getOrderDate());

        if(isOrdered) {
            informationService.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getOrderDate());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered = orderService.orderProductFromSuplier(orderRequest.getUser(), orderRequest.getOrderDate()
                ,orderRequest.getSuplier());

        if(isOrdered) {
            informationService.inform(orderRequest.getUser());
            orderRepository.createOrderFromSuplier(orderRequest.getUser(), orderRequest.getOrderDate()
                    ,orderRequest.getSuplier());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
