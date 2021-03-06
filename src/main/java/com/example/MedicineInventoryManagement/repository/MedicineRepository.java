package com.example.MedicineInventoryManagement.repository;

import com.example.MedicineInventoryManagement.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Integer> {

    List<Medicine> findByCategoryId(Integer categoryId);

    Optional<Medicine> findByMedicineName(String medicineName);

    String queryForMedicineToOrder="SELECT * FROM medicine m WHERE m.expiry_date < CURRENT_DATE OR m.is_in_stock=false OR m.total_quantity < 5";
    @Query(value = queryForMedicineToOrder, nativeQuery = true)
    List<Medicine> getMedicineToOrder();
}
