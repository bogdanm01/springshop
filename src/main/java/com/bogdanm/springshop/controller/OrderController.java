package com.bogdanm.springshop.controller;

import com.bogdanm.springshop.data.dto.Request.Order.OrderRequest;
import com.bogdanm.springshop.data.dto.Response.OrderResponse;
import com.bogdanm.springshop.shared.web.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getAllOrders() {
        throw new NotImplementedException();
    }

    @GetMapping("{order-number}")
    public ResponseEntity<ApiResponse<OrderResponse>> getOrderByOrderNumber(@PathVariable("order-number") String orderNumber) {
        throw new NotImplementedException();
    }

    @PostMapping
    public ResponseEntity<ApiResponse<OrderResponse>> createOrder(@RequestBody OrderRequest orderRequest) {
        throw new NotImplementedException();
    }
}
