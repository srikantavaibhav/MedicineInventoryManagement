package com.example.MedicineInventoryManagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MedicineResponseDto {
    private Long medicineId;
    private String medicineName;
    private Long categoryId;
    private String manufacturer;
    private String formula;
    private Date mfdDate;
    private Date expiryDate;
    private String dosage;
    private Long quantity;
    private String unit;
    private Long totalQuantity;
    private Long costPerUnit;
    private Boolean isInStock;
    private String categoryName;
}
