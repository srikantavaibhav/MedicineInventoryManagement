package com.example.MedicineInventoryManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequestDto {
    private Integer categoryId;
    private String categoryName;
    private String location;
}
