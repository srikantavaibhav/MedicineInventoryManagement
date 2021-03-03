package com.example.MedicineInventoryManagement.service;

import com.example.MedicineInventoryManagement.dto.CategoryResponseDto;

public interface CategoryService {
    CategoryResponseDto getCategoryLocation(Long categoryId);
}
