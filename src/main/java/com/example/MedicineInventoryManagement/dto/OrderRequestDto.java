package com.example.MedicineInventoryManagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderRequestDto {
    private Long orderId;
    private Long medicineId;
    private Long medicineQuantity;
    private Long totalAmount;
    private Date orderDate;
    private String orderStatus;
}
