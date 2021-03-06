package com.example.MedicineInventoryManagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MedicineResponseDto {
    private Integer medicineId;
    private String medicineName;
    private Integer categoryId;
    private String manufacturer;
    private String formula;
    private Date mfdDate;
    private Date expiryDate;
    private String dosage;
    private Short quantity;
    private String unit;
    private Integer totalQuantity;
    private Integer costPerUnit;
    private Boolean isInStock;
    private String categoryName;

}
