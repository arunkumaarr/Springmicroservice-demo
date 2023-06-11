package com.springmicro.orderservice.service;

import com.springmicro.orderservice.model.OrderRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


public interface OrderService {
    long placeorder(OrderRequest orderRequest);
}
