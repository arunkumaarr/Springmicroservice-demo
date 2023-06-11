package com.springmicro.orderservice.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomExceptionOrder extends RuntimeException{

    private String Errorcode;
    private int status;

    public CustomExceptionOrder(String message,String errorcode,int status){
        super(message);
        this.status = status;
        this.Errorcode = errorcode;
    }


}
