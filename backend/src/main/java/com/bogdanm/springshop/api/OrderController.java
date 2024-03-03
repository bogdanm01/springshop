package com.bogdanm.springshop.api;

import com.bogdanm.springshop.data.dto.Request.Order.OrderRequest;
import com.bogdanm.springshop.data.dto.Response.OrderResponse;
import com.bogdanm.springshop.data.web.ApiResponse;
import com.bogdanm.springshop.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

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
        var response = orderService.createOrder(orderRequest);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<?>> deleteOrder(@PathVariable("id") String id) {
        return null;
    }
}
