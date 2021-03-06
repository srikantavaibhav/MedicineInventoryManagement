package com.example.MedicineInventoryManagement.controllers;

import com.example.MedicineInventoryManagement.dto.MedicineRequestDto;
import com.example.MedicineInventoryManagement.dto.MedicineResponseDto;
import com.example.MedicineInventoryManagement.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/medicine")
@CrossOrigin
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    //POST - /medicine/createMedicine
//    @CrossOrigin
    @PostMapping("/createMedicine")
    public MedicineResponseDto createMedicine(@RequestBody MedicineRequestDto medicineRequestDto){
        return medicineService.createMedicine(medicineRequestDto);
    }

    //GET - /medicine/viewMedicine
  //  @CrossOrigin
    @GetMapping("/viewMedicine")
    public MedicineResponseDto getMedicineByName(@RequestParam("medicineName") String medicineName){
        return medicineService.getMedicineByName(medicineName);
    }

    //PUT - /medicine/updateMedicine
  //  @CrossOrigin
    @PutMapping("/updateMedicine/{medicineId}")
    public MedicineResponseDto updateMedicineById(@PathVariable("medicineId") Integer medicineId, @RequestBody MedicineRequestDto medicineRequestDto){
        return medicineService.updateMedicineById(medicineId, medicineRequestDto);
    }

    //DELETE - /medicine/deleteMedicine
   // @CrossOrigin
    @DeleteMapping("/deleteMedicine/{medicineId}")
    public MedicineResponseDto deleteMedicineById(@PathVariable("medicineId") Integer medicineId){
        return medicineService.deleteMedicineById(medicineId);
    }

    //GET - /medicine/viewMedicineListByCategory
   // @CrossOrigin
    @GetMapping("/viewMedicineListByCategory")
    public List<MedicineResponseDto> getMedicineListByCategoryName(@RequestParam("categoryName") String categoryName){
        return medicineService.getMedicineByCategoryName(categoryName);
    }

    //GET - /medicine/viewMedicineList
  //  @CrossOrigin
    @GetMapping("/viewMedicineList")
    public List<MedicineResponseDto> getMedicineList(){
        return medicineService.getMedicineList();
    }

    //GET - /medicine/viewMedicineToOrder
   // @CrossOrigin
    @GetMapping("/viewMedicineToOrder")
    public List<MedicineResponseDto> getMedicineToOrder(){
        return medicineService.getMedicineToOrder();
    }


}
