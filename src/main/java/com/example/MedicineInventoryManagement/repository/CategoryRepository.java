package com.example.MedicineInventoryManagement.repository;

import com.example.MedicineInventoryManagement.entity.Category;
import com.example.MedicineInventoryManagement.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findCategoryIdByCategoryName(String categoryName);

    @Query("SELECT COUNT(*) FROM Medicine m WHERE m.categoryId=:categoryId")
    Integer getCountOfMedicinesInCategory(@Param("categoryId") Integer categoryId);
}
