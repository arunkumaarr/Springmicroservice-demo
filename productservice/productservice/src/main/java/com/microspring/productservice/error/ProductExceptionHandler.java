package com.microspring.productservice.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.microspring.productservice.model.ErrorResponse;

@RestControllerAdvice
public class ProductExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleproductnotfoundexception(ProductNotFoundException exception){
        return new ResponseEntity<>(new ErrorResponse()
                .builder()
                .errormessage(exception.getMessage())
                .errorcode(exception.getErrorCode())
                .build()
                ,HttpStatus.NOT_FOUND);
    }

}
