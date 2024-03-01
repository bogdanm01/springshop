package com.bogdanm.springshop.data.dto.Response;

import com.bogdanm.springshop.data.dto.Request.Order.OrderItemDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class OrderResponse {

    @JsonProperty("order_number")
    private UUID orderNumber;

    // ? reconsider pojos folder organization
    private List<OrderItemDto> orderItems;

    @JsonProperty("total_price")
    private BigDecimal totalPrice;
}
