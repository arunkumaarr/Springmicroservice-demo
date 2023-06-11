package com.springmicro.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {

    private long productid;
    private long totalamount;
    private long quantity;
    private PaymentMode paymentMode;
}
