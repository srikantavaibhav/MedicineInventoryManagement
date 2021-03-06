package com.example.MedicineInventoryManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponseDto {
    private Integer categoryId;
    private String categoryName;
    private String location;
    private Integer numberOfMedicines;
}
