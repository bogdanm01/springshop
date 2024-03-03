package com.bogdanm.springshop.services;

import com.bogdanm.springshop.data.dto.Request.Order.OrderRequest;
import com.bogdanm.springshop.data.dto.Response.OrderResponse;
import com.bogdanm.springshop.data.web.ApiResponse;
import com.bogdanm.springshop.repository.OrderRepository;
import com.bogdanm.springshop.util.ApiResponseFactory;
import com.bogdanm.springshop.util.mapstruct.OrderMapper;
import com.bogdanm.springshop.util.validation.ValidationRules.ConstraintValidationRule;
import com.bogdanm.springshop.util.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OrderService {

    private final ConstraintValidationRule<OrderRequest> constraintValidationRule;
    private final OrderRepository orderRepository;
    private final ApiResponseFactory<OrderResponse> responseFactory;
    private final OrderMapper orderMapper;

    @Transactional
    public ApiResponse<OrderResponse> createOrder(OrderRequest orderRequest) {
        var validationResult = Validator.<OrderRequest>builder()
                .addRule(constraintValidationRule)
                .build()
                .validate(orderRequest);

        if (validationResult.isNotValid()) {
            return ApiResponse.<OrderResponse>builder()
                    .badRequest(validationResult.getMessages())
                    .build();
        }

        // TODO: Map OrderRequest to Order
        // TODO: Add more validation rules
        // TODO: Generate unique order number
        // TODO: Persist order
        // TODO: Send email

        return responseFactory.successfulOperation();
    }
}
