package com.example.orders.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDTO {
    private Long orderId;

    private String customerName;
    private String email;
    private String productName;
    private Integer quantity;
    private Double pricePerUnit;
    private Double totalAmount;

    public OrderResponseDTO() {
    }

    public OrderResponseDTO(Long orderid, String customerName, String email, String productName, Integer quantity, Double pricePerUnit, Double totalAmount) {
        this.orderId = orderid;
        this.customerName = customerName;
        this.email = email;
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.totalAmount = totalAmount;
    }
}
