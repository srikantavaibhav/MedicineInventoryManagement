package com.example.MedicineInventoryManagement.controllers;

import com.example.MedicineInventoryManagement.dto.OrderRequestDto;
import com.example.MedicineInventoryManagement.dto.OrderResponseDto;
import com.example.MedicineInventoryManagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //POST - /order/createOrder
    @CrossOrigin
    @PostMapping("/createOrder")
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto orderRequestDto){
        return orderService.createOrder(orderRequestDto);
    }

    //GET - /order/getOrderList
    @CrossOrigin
    @GetMapping("/getOrderList")
    public List<OrderResponseDto> getOrderList(){
        return orderService.getOrderList();
    }

    //DELETE - /order/deleteOrderById
    @CrossOrigin
    @DeleteMapping("/deleteOrderById")
    public OrderResponseDto deleteOrderById(Long orderId){
        return orderService.deleteOrderById(orderId);
    }
}
