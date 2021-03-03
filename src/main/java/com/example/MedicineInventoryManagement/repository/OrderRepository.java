package com.example.MedicineInventoryManagement.repository;

import com.example.MedicineInventoryManagement.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long> {
}
