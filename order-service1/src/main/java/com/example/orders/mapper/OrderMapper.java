package com.example.orders.mapper;

import com.example.orders.dto.OrderRequestDTO;
import com.example.orders.dto.OrderResponseDTO;
import com.example.orders.entity.OrderEntity;

public class OrderMapper {

    public static OrderEntity toEntity(OrderRequestDTO dto) {
        OrderEntity e = new OrderEntity(dto.getCustomerName(),dto.getEmail(),dto.getProductName(),dto.getQuantity(),dto.getPricePerUnit(),dto.getTotalAmount());
        return e;
    }

    public static OrderResponseDTO toResponseDTO(OrderEntity entity) {
        OrderResponseDTO dto = new OrderResponseDTO(entity.getId(), entity.getCustomerName(), entity.getEmail(),entity.getProductName(), entity.getQuantity(),entity.getPricePerUnit(),entity.getTotalAmount());
        return dto;
    }
}
