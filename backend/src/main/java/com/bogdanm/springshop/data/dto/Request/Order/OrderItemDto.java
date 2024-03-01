package com.bogdanm.springshop.data.dto.Request.Order;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class OrderItemDto {

    @NotBlank
    private String skuCode;

    @Min(1)
    private int orderedQuantity;
}
