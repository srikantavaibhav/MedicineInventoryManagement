package com.example.MedicineInventoryManagement.service.Impl;

import com.example.MedicineInventoryManagement.dto.OrderRequestDto;
import com.example.MedicineInventoryManagement.dto.OrderResponseDto;
import com.example.MedicineInventoryManagement.entity.MedicineOrder;
import com.example.MedicineInventoryManagement.repository.OrderRepository;
import com.example.MedicineInventoryManagement.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto){
        MedicineOrder order = new MedicineOrder();

        BeanUtils.copyProperties(orderRequestDto, order);

        MedicineOrder savedOrder = orderRepository.save(order);

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        BeanUtils.copyProperties(savedOrder, orderResponseDto);

        return orderResponseDto;
    }

    @Override
    public List<OrderResponseDto> getOrderList(){
        List<MedicineOrder> orderList = (List<MedicineOrder>) orderRepository.findAll();
        List<OrderResponseDto> orderResponseDtoList = new ArrayList<>();
        for(MedicineOrder order: orderList)
        {
            OrderResponseDto orderResponseDto = new OrderResponseDto();
            BeanUtils.copyProperties(order, orderResponseDto);
            orderResponseDtoList.add(orderResponseDto);
        }
        return orderResponseDtoList;
    }

    @Override
    public OrderResponseDto deleteOrderById(Integer orderId){
        Optional<MedicineOrder> orderOptionalFromDb = orderRepository.findById(orderId);
        if(orderOptionalFromDb.isPresent())
        {
            OrderResponseDto orderResponseDto = new OrderResponseDto();
            BeanUtils.copyProperties(orderOptionalFromDb.get(),orderResponseDto);
            orderRepository.deleteById(orderId);
            return orderResponseDto;
        }
        return null;
    }
}
