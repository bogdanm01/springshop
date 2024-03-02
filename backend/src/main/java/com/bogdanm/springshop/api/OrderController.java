package com.bogdanm.springshop.api;

import com.bogdanm.springshop.data.dto.Request.Order.OrderRequest;
import com.bogdanm.springshop.data.dto.Response.OrderResponse;
import com.bogdanm.springshop.data.web.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getAllOrders() {
        return null;
    }

    @GetMapping("{order-number}")
    public ResponseEntity<ApiResponse<OrderResponse>> getOrderByOrderNumber(@PathVariable("order-number") String orderNumber) {
        return null;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<OrderResponse>> createOrder(@RequestBody OrderRequest orderRequest) {
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<?>> deleteOrder(@PathVariable("id") String id) {
        return null;
    }
}
