package com.springmicro.orderservice.controller;

import com.springmicro.orderservice.model.OrderRequest;
import com.springmicro.orderservice.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Log4j2
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeorder")
    public ResponseEntity<Long> placeorder(@RequestBody OrderRequest orderRequest){
        long orderid = orderService.placeorder(orderRequest);
        log.info("order id: {}", orderid);
        return new ResponseEntity<>(orderid, HttpStatus.OK);
    }

}
