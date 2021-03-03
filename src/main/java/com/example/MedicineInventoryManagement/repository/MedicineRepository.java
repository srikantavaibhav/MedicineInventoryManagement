package com.example.MedicineInventoryManagement.repository;

import com.example.MedicineInventoryManagement.entity.Medicine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MedicineRepository extends CrudRepository<Medicine,Long> {

//    @Query("SELECT m FROM Medicine m WHERE m.category.id=:categoryId")
//    List<Medicine> getMedicineListByCategoryIdParam(@Param("categoryId") Long categoryId);

    List<Medicine> findByCategoryId(Long categoryId);

    Optional<Medicine> findByMedicineName(String medicineName);
}
