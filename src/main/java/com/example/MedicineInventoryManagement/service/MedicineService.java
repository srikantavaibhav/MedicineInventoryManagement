package com.example.MedicineInventoryManagement.service;

import com.example.MedicineInventoryManagement.dto.MedicineRequestDto;
import com.example.MedicineInventoryManagement.dto.MedicineResponseDto;

import java.util.List;

public interface MedicineService {
    MedicineResponseDto createMedicine(MedicineRequestDto medicineRequestDto);
    MedicineResponseDto getMedicineById(Long medicineId);
    MedicineResponseDto updateMedicineById(Long medicineId, MedicineRequestDto medicineRequestDto);
//    MedicineResponseDto deleteMedicineById(Long medicineId);
//    List<MedicineResponseDto> getMedicineByCategory(Long categoryId);

    //String getMedicineLocation(Long categoryId);
//    MedicineResponseDto updateAvailability(Long medicineId, MedicineRequestDto medicineRequestDto);
}
