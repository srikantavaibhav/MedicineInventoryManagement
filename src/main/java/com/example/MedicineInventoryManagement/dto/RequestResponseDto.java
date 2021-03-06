package com.example.MedicineInventoryManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestResponseDto {
    private Integer requestId;
    private Integer medicineId;
    private Integer categoryId;
    private Integer medicineQuantity;
    private String reason;
}
