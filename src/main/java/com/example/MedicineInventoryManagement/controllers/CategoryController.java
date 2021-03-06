package com.example.MedicineInventoryManagement.controllers;

import com.example.MedicineInventoryManagement.dto.CategoryRequestDto;
import com.example.MedicineInventoryManagement.dto.CategoryResponseDto;
import com.example.MedicineInventoryManagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //POST - /category/createCategory
    @CrossOrigin
    @PostMapping("/createCategory")
    public CategoryResponseDto createCategory(@RequestBody CategoryRequestDto categoryRequestDto){
        return categoryService.createCategory(categoryRequestDto);
    }

    //GET - /category/viewCategoryList
    @CrossOrigin
    @GetMapping("/viewCategoryList")
    public List<CategoryResponseDto> getCategoryList(){
        return categoryService.getCategoryList();
    }

}
