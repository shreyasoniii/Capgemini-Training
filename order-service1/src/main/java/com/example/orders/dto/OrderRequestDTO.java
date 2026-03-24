package com.example.orders.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {
    @Max(100)
    private Long orderid;
    @Size(min=3)
    @NotNull
    @NotEmpty
    private String customerName;
    @Email
    @NotEmpty
    @NotNull
    private String email;
    @NotNull
    @NotEmpty
    private String productName;
    @NotNull
    @Min(1)
    private Integer quantity;
    @NotNull
    @Min(1)
    private Double pricePerUnit;
    private Double totalAmount;


}
