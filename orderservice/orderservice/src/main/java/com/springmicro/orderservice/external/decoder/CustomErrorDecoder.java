package com.springmicro.orderservice.external.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springmicro.orderservice.error.CustomExceptionOrder;
import com.springmicro.orderservice.external.Response.ErrorResponse;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper objectMapper = new ObjectMapper();

        log.info("::{}",response.request().url());
        log.info("::{}",response.request().headers());

        try {
            ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
            return new CustomExceptionOrder(errorResponse.getErrorMessage(),errorResponse.getErrorCode(), response.status());
        } catch (IOException e) {
            throw new CustomExceptionOrder("internal server error ", "internal error ",500);
        }
    }
}
