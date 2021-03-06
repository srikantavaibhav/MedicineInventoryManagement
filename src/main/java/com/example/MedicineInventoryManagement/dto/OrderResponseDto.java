package com.example.MedicineInventoryManagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderResponseDto {
    private Integer orderId;
    private Integer medicineId;
    private Integer medicineQuantity;
    private Long totalAmount;
    private Date orderDate;

}
