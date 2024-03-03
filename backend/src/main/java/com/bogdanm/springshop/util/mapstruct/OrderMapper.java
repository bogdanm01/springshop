package com.bogdanm.springshop.util.mapstruct;

import com.bogdanm.springshop.data.dto.Request.Order.OrderRequest;
import com.bogdanm.springshop.data.dto.Response.OrderResponse;
import com.bogdanm.springshop.data.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface OrderMapper {

    /**
     * Maps an {@link OrderRequest} object to an {@link Order} entity.
     *
     * @param orderRequest The source {@link OrderRequest} object.
     * @return The mapped {@link Order} entity.
     */
    Order toEntity(OrderRequest orderRequest, String orderNumber);

    /**
     * Maps an {@link Order} entity to an {@link OrderResponse}.
     *
     * @param order The source {@link Order} entity object.
     * @return The mapped {@link OrderRequest} object.
     */
    OrderResponse toResponse(Order order);
}
