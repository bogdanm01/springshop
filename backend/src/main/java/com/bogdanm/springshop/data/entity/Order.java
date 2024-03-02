package com.bogdanm.springshop.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "order_number", nullable = false)
    private String orderNumber;

//    @Column(name = "order_status")
//    @Enumerated(EnumType.STRING)
//    private OrderStatus orderStatus;

    // TODO: Add user relation

    // TODO: Add delivery address relation

    // TODO: Add products relation

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;
}
