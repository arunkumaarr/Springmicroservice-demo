package com.microspring.productservice.service;

import com.microspring.productservice.entity.Product;
import com.microspring.productservice.model.ProductRequest;
import com.microspring.productservice.model.ProductResponse;

public interface ProductService {
    long addproduct(ProductRequest productRequest);

    ProductResponse getProductByid(long productid);

    void reduceQuantity(long productid, long quantity);
}
