package com.example.MedicineInventoryManagement.repository;

import com.example.MedicineInventoryManagement.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Long> {
    Optional<Category> findCategoryIdByCategoryName(String categoryName);
}
