package com.example.MedicineInventoryManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestResponseDto {
    private Long requestId;
    private Long medicineId;
    private String status;
    private String reason;
}
