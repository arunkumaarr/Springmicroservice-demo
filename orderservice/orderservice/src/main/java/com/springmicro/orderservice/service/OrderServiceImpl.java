package com.springmicro.orderservice.service;

import com.springmicro.orderservice.entity.Order;
import com.springmicro.orderservice.external.client.ProductService;
import com.springmicro.orderservice.model.OrderRequest;
import com.springmicro.orderservice.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Log4j2
@Service
public class OrderServiceImpl implements OrderService{


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Override
    public long placeorder(OrderRequest orderRequest) {
        log.info("Order Trying to be placed : {}", orderRequest.toString());

        productService.reduceproduct(orderRequest.getProductid(),orderRequest.getQuantity());

        log.info("creating order with status : created");

        Order order = orderRepository.save(Order.builder()
                        .amount(orderRequest.getTotalamount())
                        .id(orderRequest.getProductid())
                        .orderStatus("Created")
                        .orderDate(Instant.now())
                        .quantity(orderRequest.getQuantity())
                .build());

        log.info("order created : {}", order.getId());
        return order.getId();
    }
}
