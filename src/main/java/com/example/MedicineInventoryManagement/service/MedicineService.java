package com.example.MedicineInventoryManagement.service;

import com.example.MedicineInventoryManagement.dto.MedicineRequestDto;
import com.example.MedicineInventoryManagement.dto.MedicineResponseDto;

import java.util.List;

public interface MedicineService {
    MedicineResponseDto createMedicine(MedicineRequestDto medicineRequestDto);
//    MedicineResponseDto getMedicineById(Long medicineId);
//    MedicineResponseDto updateMedicineById(Long medicineId, MedicineRequestDto medicineRequestDto);
    MedicineResponseDto deleteMedicineByName(String medicineName);
    List<MedicineResponseDto> getMedicineByCategoryName(String categoryName);

    MedicineResponseDto getMedicineByName(String medicineName);

    MedicineResponseDto updateMedicineByName(String medicineName, MedicineRequestDto medicineRequestDto);

    List<MedicineResponseDto> getMedicineList();

//    List<MedicineResponseDto> getOutOfStockMedicineList();
//
//    List<MedicineResponseDto> getExpiredMedicineList() throws Exception;

    List<MedicineResponseDto> getMedicineToOrder();

    //List<MedicineResponseDto> getOutOfStock_Or_ExpiredMedicineList();

    //String getMedicineLocation(Long categoryId);
//    MedicineResponseDto updateAvailability(Long medicineId, MedicineRequestDto medicineRequestDto);
}
