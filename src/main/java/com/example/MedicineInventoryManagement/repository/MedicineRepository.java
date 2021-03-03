package com.example.MedicineInventoryManagement.repository;

import com.example.MedicineInventoryManagement.entity.Medicine;
import org.springframework.data.repository.CrudRepository;

public interface MedicineRepository extends CrudRepository<Medicine,Long> {
}
