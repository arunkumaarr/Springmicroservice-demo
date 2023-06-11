package com.microspring.productservice.service;

import com.microspring.productservice.entity.Product;
import com.microspring.productservice.error.ProductNotFoundException;
import com.microspring.productservice.model.ProductRequest;
import com.microspring.productservice.model.ProductResponse;
import com.microspring.productservice.repository.ProductRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addproduct(ProductRequest productRequest) {
        log.info("Adding product...");
        Product product = Product.builder()
                .productname(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);

        log.info("product created ....");

        return product.getProductid();
    }

    @Override
    public ProductResponse getProductByid(long productid) {
        log.info("get product for id :" + productid);

        Product product = productRepository.findById(productid).orElseThrow(() -> new ProductNotFoundException("Product Not found ", HttpStatus.NOT_FOUND.toString()));

        ProductResponse productResponse = new ProductResponse();

        BeanUtils.copyProperties(product,productResponse);
        return productResponse;

    }

    @Override
    public void reduceQuantity(long productid, long quantity) {
        log.info("Reduce Quantity {} for product id : {}",quantity,productid);

        Product product = productRepository.findById(productid).orElseThrow(() -> new ProductNotFoundException("Product Not found ", HttpStatus.NOT_FOUND.toString()));

        if(product.getQuantity() < quantity){
            throw new ProductNotFoundException("Product Does not have Sufficient quantity","insufficient_Quantity");
        }

        product.setQuantity(product.getQuantity()-quantity);
        productRepository.save(product);

        log.info("product quantity updated successfully ");


    }


}
