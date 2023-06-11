package com.springmicro.orderservice.error;


import com.springmicro.orderservice.external.Response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ProductExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(CustomExceptionOrder.class)
    public ResponseEntity<ErrorResponse> handlecustomexception(CustomExceptionOrder exception){
        return new ResponseEntity<>(new ErrorResponse()
                .builder()
                .errorMessage(exception.getMessage())
                .errorCode(exception.getErrorcode())
                .build()
                ,HttpStatus.NOT_FOUND);
    }

}
