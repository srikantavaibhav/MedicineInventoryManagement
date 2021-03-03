package com.example.MedicineInventoryManagement.controllers;

import com.example.MedicineInventoryManagement.dto.MedicineRequestDto;
import com.example.MedicineInventoryManagement.dto.MedicineResponseDto;
import com.example.MedicineInventoryManagement.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    //POST - /medicine
    @PostMapping
    public MedicineResponseDto createMedicine(@RequestBody MedicineRequestDto medicineRequestDto){
        return medicineService.createMedicine(medicineRequestDto);
    }

    //GET - /medicine/{medicineId}
    @GetMapping("/{medicineId}")
    public MedicineResponseDto getMedicineById(@PathVariable("medicineId") Long medicineId){
        return medicineService.getMedicineById(medicineId);
    }

    //PUT - /medicine/{medicineId}
    @PutMapping("/{medicineId}")
    public MedicineResponseDto updateMedicineById(@PathVariable("medicineId") Long medicineId, @RequestBody MedicineRequestDto medicineRequestDto){
        return medicineService.updateMedicineById(medicineId, medicineRequestDto);
    }
//
//    //DELETE - /medicine{id}
//    @DeleteMapping("/medicineId")
//    public MedicineResponseDto deleteMedicineById(@PathVariable("medicineId") Long medicineId){
//        return medicineService.deleteMedicineById(medicineId);
//    }
//
//    //GET - /medicine/category/{categoryId}
//    @GetMapping("/category/{categoryId}")
//    public List<MedicineResponseDto> getMedicineListByCategory(@PathVariable("categoryId") Long categoryId){
//        return medicineService.getMedicineByCategory(categoryId);
//    }
}
