package com.example.MedicineInventoryManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestRequestDto {
    private Long requestId;
    private Long medicineId;
    private Long categoryId;
    private Long medicineQuantity;
    private String status;
    private String reason;

}
