package com.example.MedicineInventoryManagement.service;

import com.example.MedicineInventoryManagement.dto.MedicineRequestDto;
import com.example.MedicineInventoryManagement.dto.MedicineResponseDto;

import java.util.List;

public interface MedicineService {
    MedicineResponseDto createMedicine(MedicineRequestDto medicineRequestDto);

    MedicineResponseDto deleteMedicineById(Integer medicineId);

    List<MedicineResponseDto> getMedicineByCategoryName(String categoryName);

    MedicineResponseDto getMedicineByName(String medicineName);

    MedicineResponseDto updateMedicineById(Integer medicineId, MedicineRequestDto medicineRequestDto);

    List<MedicineResponseDto> getMedicineList();

    List<MedicineResponseDto> getMedicineToOrder();

}
