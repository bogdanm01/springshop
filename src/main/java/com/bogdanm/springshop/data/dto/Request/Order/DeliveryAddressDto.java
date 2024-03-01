package com.bogdanm.springshop.data.dto.Request.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
public class DeliveryAddressDto {
    private UUID id;

    // ! fields below must have value if id is null
    // * create custom constraint annotation
    private String city;
    private String zipCode;
    private String street;
    private String buildingNumber;
}
