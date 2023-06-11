package com.springmicro.orderservice.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="PRODUCT-SERVICE/product")
public interface ProductService {

    @PutMapping("/reducequantity/{productid}")
    public ResponseEntity<Void> reduceproduct(@PathVariable("productid") long productid,
                                              @RequestParam("quantity") long quantity);
}
