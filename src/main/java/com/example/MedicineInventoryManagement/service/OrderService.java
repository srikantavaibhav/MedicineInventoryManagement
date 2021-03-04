package com.example.MedicineInventoryManagement.service;

import com.example.MedicineInventoryManagement.dto.OrderRequestDto;
import com.example.MedicineInventoryManagement.dto.OrderResponseDto;

import java.util.List;

public interface OrderService {
    OrderResponseDto createOrder(OrderRequestDto orderRequestDto);
    List<OrderResponseDto> getOrderList();
    OrderResponseDto deleteOrderById(Long orderId);

}
