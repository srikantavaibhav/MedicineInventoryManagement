package com.example.MedicineInventoryManagement.repository;

import com.example.MedicineInventoryManagement.entity.MedicineOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<MedicineOrder,Long> {
}
