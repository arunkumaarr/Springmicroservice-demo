package com.microspring.productservice.controller;

import com.microspring.productservice.model.ProductRequest;
import com.microspring.productservice.model.ProductResponse;
import com.microspring.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping
    public ResponseEntity<Long> addproduct(@RequestBody ProductRequest productRequest){
        long productid = productService.addproduct(productRequest);
        return new ResponseEntity<>(productid,HttpStatus.CREATED);
    }

    @GetMapping("/{productid}")
    public ResponseEntity<ProductResponse> getproduct(@PathVariable("productid") long productid){
        return new ResponseEntity<>(productService.getProductByid(productid),HttpStatus.FOUND);
    }


    @GetMapping("/requestparam")
    public ResponseEntity<ProductResponse> getproduct_param(@RequestParam long productid){
        return new ResponseEntity<>(productService.getProductByid(productid),HttpStatus.FOUND);
    }


    @PutMapping("/reducequantity/{productid}")
    public ResponseEntity<Void> reduceproduct(@PathVariable("productid") long productid,
                                                         @RequestParam("quantity") long quantity){
        productService.reduceQuantity(productid, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
