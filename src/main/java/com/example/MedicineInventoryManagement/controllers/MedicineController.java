package com.example.MedicineInventoryManagement.controllers;

import com.example.MedicineInventoryManagement.dto.MedicineRequestDto;
import com.example.MedicineInventoryManagement.dto.MedicineResponseDto;
import com.example.MedicineInventoryManagement.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    //POST - /medicine/createMedicine
    @CrossOrigin
    @PostMapping("/createMedicine")
    public MedicineResponseDto createMedicine(@RequestBody MedicineRequestDto medicineRequestDto){
        return medicineService.createMedicine(medicineRequestDto);
    }
//
//    //GET - /medicine/{medicineId}
//    @GetMapping("/{medicineId}")
//    public MedicineResponseDto getMedicineById(@PathVariable("medicineId") Long medicineId){
//        return medicineService.getMedicineById(medicineId);
//    }
//
//    //PUT - /medicine/{medicineId}
//    @PutMapping("/{medicineId}")
//    public MedicineResponseDto updateMedicineById(@PathVariable("medicineId") Long medicineId, @RequestBody MedicineRequestDto medicineRequestDto){
//        return medicineService.updateMedicineById(medicineId, medicineRequestDto);
//    }

//    //DELETE - /medicine/{medicineId}
//    @DeleteMapping("/{medicineId}")
//    public MedicineResponseDto deleteMedicineById(@PathVariable("medicineId") Long medicineId){
//        return medicineService.deleteMedicineById(medicineId);
//    }

//    //GET - /medicine/category/{categoryId}
//    @GetMapping("/category/{categoryId}")
//    public List<MedicineResponseDto> getMedicineListByCategory(@RequestParam("categoryId") Long categoryId){
//        return medicineService.getMedicineByCategory(categoryId);
//    }

    //GET - /medicine/getMedicine
    @CrossOrigin
    @GetMapping("/getMedicine")
    public MedicineResponseDto getMedicineByName(@RequestParam("medicineName") String medicineName){
        return medicineService.getMedicineByName(medicineName);
    }

    //PUT - /medicine/updateMedicine
    @CrossOrigin
    @PutMapping("/updateMedicine")
    public MedicineResponseDto updateMedicineByName(@RequestParam("medicineName") String medicineName, @RequestBody MedicineRequestDto medicineRequestDto){
        return medicineService.updateMedicineByName(medicineName, medicineRequestDto);
    }

    //DELETE - /medicine/deleteMedicine
    @CrossOrigin
    @DeleteMapping("/deleteMedicine")
    public MedicineResponseDto deleteMedicineByName(@RequestParam("medicineName") String medicineName){
        return medicineService.deleteMedicineByName(medicineName);
    }

    //GET - /medicine/getMedicineListByCategory
    @CrossOrigin
    @GetMapping("/getMedicineListByCategory")
    public List<MedicineResponseDto> getMedicineListByCategoryName(@RequestParam("categoryName") String categoryName){
        return medicineService.getMedicineByCategoryName(categoryName);
    }

    //GET - /medicine/getMedicineList
    @CrossOrigin
    @GetMapping("/getMedicineList")
    public List<MedicineResponseDto> getMedicineList(){
        return medicineService.getMedicineList();
    }

    //GET - /medicine/getOutOfStockMedicineList
    @CrossOrigin
    @GetMapping("/getOutOfStockMedicineList")
    public List<MedicineResponseDto> getOutOfStockMedicineList(){
        return medicineService.getOutOfStockMedicineList();
    }

    //GET - /medicine/getExpiredMedicineList
    @CrossOrigin
    @GetMapping("/getExpiredMedicineList")
    public List<MedicineResponseDto> getExpiredMedicineList(){
        List<MedicineResponseDto> medicineResponseDtoList = new ArrayList<>();
       try{
           medicineResponseDtoList=medicineService.getExpiredMedicineList();
       }catch(Exception e){
           System.out.println(e);
       };
       return medicineResponseDtoList;
    }

//    //GET - /medicine/getOutOfStock_Or_ExpiredMedicineList
//    @CrossOrigin
//    @GetMapping("/getOutOfStock_Or_ExpiredMedicineList")
//    public List<MedicineResponseDto> getOutOfStock_Or_ExpiredMedicineList(){
//        return medicineService.getOutOfStock_Or_ExpiredMedicineList();
//    }
}
