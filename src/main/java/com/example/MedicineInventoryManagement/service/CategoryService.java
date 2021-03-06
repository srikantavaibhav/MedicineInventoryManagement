package com.example.MedicineInventoryManagement.service;

import com.example.MedicineInventoryManagement.dto.CategoryRequestDto;
import com.example.MedicineInventoryManagement.dto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {

    CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto);

    List<CategoryResponseDto> getCategoryList();

}
