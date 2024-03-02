package com.bogdanm.springshop.data.dto.Request.Order;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    @NotEmpty
    @NotNull
    private List<OrderItemDto> orderItems;

    @NotNull
    private UserDto user;

    @NotNull
    private DeliveryAddressDto deliveryAddressDto;

    @NotNull
    private boolean saveDeliveryAddress;
}
