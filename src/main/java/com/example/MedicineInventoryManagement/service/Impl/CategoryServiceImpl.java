package com.example.MedicineInventoryManagement.service.Impl;

import com.example.MedicineInventoryManagement.dto.CategoryRequestDto;
import com.example.MedicineInventoryManagement.dto.CategoryResponseDto;
import com.example.MedicineInventoryManagement.entity.Category;
import com.example.MedicineInventoryManagement.repository.CategoryRepository;
import com.example.MedicineInventoryManagement.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto){
        Category category = new Category();
        BeanUtils.copyProperties(categoryRequestDto, category);
        Category savedCategory = categoryRepository.save(category);
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        BeanUtils.copyProperties(savedCategory, categoryResponseDto);
        categoryResponseDto.setNumberOfMedicines(categoryRepository.getCountOfMedicinesInCategory(categoryResponseDto.getCategoryId()));
        return categoryResponseDto;
    }

    @Override
    public List<CategoryResponseDto> getCategoryList() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryResponseDto> categoryResponseDtoList = new ArrayList<>();
        for(Category category: categoryList)
        {
            CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
            BeanUtils.copyProperties(category, categoryResponseDto);
            categoryResponseDto.setNumberOfMedicines(categoryRepository.getCountOfMedicinesInCategory(categoryResponseDto.getCategoryId()));
            categoryResponseDtoList.add(categoryResponseDto);
        }
        return categoryResponseDtoList;
    }
}
