package com.example.orders.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String email;
    private String productName;
    private Integer quantity;
    private Double pricePerUnit;
    private Double totalAmount;

    public OrderEntity(String customerName, String productName, String email, Integer quantity, Double totalAmount, Double pricePerUnit) {
        this.customerName = customerName;
        this.productName = productName;
        this.email = email;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.pricePerUnit = pricePerUnit;
    }

    public OrderEntity() {
    }
}
