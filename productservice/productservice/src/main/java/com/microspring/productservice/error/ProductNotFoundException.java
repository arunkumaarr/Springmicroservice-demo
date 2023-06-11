package com.microspring.productservice.error;

import lombok.Data;

@Data
public class ProductNotFoundException extends RuntimeException{

    private String errormessage;
    private String errorCode;

    public ProductNotFoundException(String errormessage,String errorCode){
        super(errormessage);
        this.errorCode = errorCode;
    }
}
