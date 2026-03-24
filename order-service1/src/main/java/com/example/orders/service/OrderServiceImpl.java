package com.example.orders.service;

import com.example.orders.dto.OrderRequestDTO;
import com.example.orders.entity.OrderEntity;
import com.example.orders.exception.OrderNotFoundException;
import com.example.orders.mapper.OrderMapper;
import com.example.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repository;


    @Override
    public OrderEntity createOrder(OrderRequestDTO request) {
        OrderEntity orderEntity= OrderMapper.toEntity(request);
//        orderEntity.setCustomerName(request.getCustomerName());
//        orderEntity.setEmail(request.getEmail());
//        orderEntity.setProductName(request.getProductName());
//        orderEntity.setQuantity(request.getQuantity());
//        orderEntity.setPricePerUnit(request.getPricePerUnit());
//        orderEntity.setTotalAmount(request.getTotalAmount());
        return repository.save(orderEntity);
    }

    @Override
    public OrderEntity getOrderById(Long id) {
        Optional<OrderEntity> op=repository.findById(id);
        if(op.isPresent()){
            return op.get();
        }
        else {
            throw new OrderNotFoundException();
        }
    }

    @Override
    public void deleteOrder(Long id) {
        if (!repository.existsById(id)) {
            throw new OrderNotFoundException();
        }
        repository.deleteById(id);
    }
}
