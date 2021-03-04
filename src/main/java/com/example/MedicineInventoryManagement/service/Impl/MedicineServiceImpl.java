package com.example.MedicineInventoryManagement.service.Impl;

import com.example.MedicineInventoryManagement.dto.MedicineRequestDto;
import com.example.MedicineInventoryManagement.dto.MedicineResponseDto;
import com.example.MedicineInventoryManagement.entity.Category;
import com.example.MedicineInventoryManagement.entity.Medicine;
import com.example.MedicineInventoryManagement.repository.CategoryRepository;
import com.example.MedicineInventoryManagement.repository.MedicineRepository;
import com.example.MedicineInventoryManagement.service.MedicineService;
import lombok.Setter;
import org.apache.commons.collections.ListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.*;

@Service(value = "MedicineServiceImpl")
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public MedicineResponseDto createMedicine(MedicineRequestDto medicineRequestDto) {
        Medicine medicine = new Medicine();

        BeanUtils.copyProperties(medicineRequestDto, medicine);

        if(medicine.getTotalQuantity() == 0 && medicine.getIsInStock() == true)
        {
            medicine.setIsInStock(false);
        }
        if(medicine.getTotalQuantity() > 0 && medicine.getIsInStock() == false)
        {
            medicine.setIsInStock(true);
        }

        Medicine savedMedicine = medicineRepository.save(medicine);

        MedicineResponseDto medicineResponseDto = new MedicineResponseDto();
        BeanUtils.copyProperties(savedMedicine, medicineResponseDto);
        medicineResponseDto.setCategoryName(categoryRepository.findById(medicineResponseDto.getCategoryId()).get().getCategoryName());

        return medicineResponseDto;
    }

//    @Override
//    public MedicineResponseDto getMedicineById(Long medicineId) {
//        Optional<Medicine> medicineOptional = medicineRepository.findById(medicineId);
//        if (medicineOptional.isPresent()) {
//            MedicineResponseDto medicineResponseDto = new MedicineResponseDto();
//            BeanUtils.copyProperties(medicineOptional.get(), medicineResponseDto);
//            return medicineResponseDto;
//        }
//        return null;
//    }
//
//    @Override
//    public MedicineResponseDto updateMedicineById(Long medicineId, MedicineRequestDto medicineRequestDto) {
//
//        if(medicineRequestDto.getTotalQuantity() == 0 && medicineRequestDto.getIsInStock() == true)
//        {
//            medicineRequestDto.setIsInStock(false);
//        }
//        if(medicineRequestDto.getTotalQuantity() > 0 && medicineRequestDto.getIsInStock() == false)
//        {
//            medicineRequestDto.setIsInStock(true);
//        }
//
//
//        Optional<Medicine> medicineOptional = medicineRepository.findById(medicineId);
//        if (medicineOptional.isPresent()) {
//            Medicine medicineFromDb = medicineOptional.get();
//            BeanUtils.copyProperties(medicineRequestDto, medicineFromDb);
//
//            Medicine savedMedicine = medicineRepository.save(medicineFromDb);
//            MedicineResponseDto medicineResponseDto = new MedicineResponseDto();
//            BeanUtils.copyProperties(savedMedicine, medicineResponseDto);
//            return medicineResponseDto;
//        }
//        return null;
//    }

//    @Override
//    public MedicineResponseDto deleteMedicineById(Long medicineId){
//        Optional<Medicine> medicineOptional = medicineRepository.findById(medicineId);
//        if(medicineOptional.isPresent())
//        {
//            MedicineResponseDto medicineResponseDto = new MedicineResponseDto();
//            BeanUtils.copyProperties(medicineOptional.get(), medicineResponseDto);
//            medicineRepository.deleteById(medicineId);
//            return medicineResponseDto;
//        }
//        return null;
//    }

    @Override
    public List<MedicineResponseDto> getMedicineByCategoryName(String categoryName){
        Optional<Category> categoryOptional=categoryRepository.findCategoryIdByCategoryName(categoryName);
        if(categoryOptional.isPresent()) {

            Long categoryId = categoryOptional.get().getCategoryId();
            List<Medicine> medicineList = medicineRepository.findByCategoryId(categoryId);
            List<MedicineResponseDto> medicineResponseDtoList = new ArrayList<>();
            for (Medicine medicine : medicineList) {
                MedicineResponseDto medicineResponseDto = new MedicineResponseDto();
                BeanUtils.copyProperties(medicine, medicineResponseDto);
                medicineResponseDto.setCategoryName(categoryRepository.findById(medicineResponseDto.getCategoryId()).get().getCategoryName());
                medicineResponseDtoList.add(medicineResponseDto);
            }
            return medicineResponseDtoList;
        }
        return null;
    }


    @Override
    public MedicineResponseDto getMedicineByName(String medicineName){

        Optional<Medicine> medicineOptional=medicineRepository.findByMedicineName(medicineName);
        if(medicineOptional.isPresent()) {

            MedicineResponseDto medicineResponseDto = new MedicineResponseDto();
            BeanUtils.copyProperties(medicineOptional.get(), medicineResponseDto);
            medicineResponseDto.setCategoryName(categoryRepository.findById(medicineResponseDto.getCategoryId()).get().getCategoryName());
            return medicineResponseDto;
        }
        return null;
    }

    @Override
    public MedicineResponseDto updateMedicineByName(String medicineName, MedicineRequestDto medicineRequestDto){
        Optional<Medicine> medicineOptionalFromDb=medicineRepository.findByMedicineName(medicineName);
        if(medicineOptionalFromDb.isPresent()) {


            if (medicineRequestDto.getTotalQuantity() == 0 && medicineRequestDto.getIsInStock() == true) {
                medicineRequestDto.setIsInStock(false);
            }
            if (medicineRequestDto.getTotalQuantity() > 0 && medicineRequestDto.getIsInStock() == false) {
                medicineRequestDto.setIsInStock(true);
            }


            BeanUtils.copyProperties(medicineRequestDto, medicineOptionalFromDb.get());

            Medicine savedMedicine = medicineRepository.save(medicineOptionalFromDb.get());
            MedicineResponseDto medicineResponseDto = new MedicineResponseDto();
            BeanUtils.copyProperties(savedMedicine, medicineResponseDto);
            medicineResponseDto.setCategoryName(categoryRepository.findById(medicineResponseDto.getCategoryId()).get().getCategoryName());
            return medicineResponseDto;
        }
        return null;
    }

    @Override
    public MedicineResponseDto deleteMedicineByName(String  medicineName){
        Optional<Medicine> medicineOptional = medicineRepository.findByMedicineName(medicineName);
        if(medicineOptional.isPresent())
        {
            MedicineResponseDto medicineResponseDto = new MedicineResponseDto();
            BeanUtils.copyProperties(medicineOptional.get(), medicineResponseDto);
            medicineRepository.deleteById(medicineResponseDto.getMedicineId());
            medicineResponseDto.setCategoryName(categoryRepository.findById(medicineResponseDto.getCategoryId()).get().getCategoryName());
            return medicineResponseDto;
        }
        return null;
    }
    @Override
    public List<MedicineResponseDto> getMedicineList(){
        List<Medicine> medicineList = (List<Medicine>) medicineRepository.findAll();
        List<MedicineResponseDto> medicineResponseDtoList = new ArrayList<>();
        for(Medicine medicine: medicineList)
        {
            MedicineResponseDto medicineResponseDto = new MedicineResponseDto();
            BeanUtils.copyProperties(medicine, medicineResponseDto);
            medicineResponseDto.setCategoryName(categoryRepository.findById(medicineResponseDto.getCategoryId()).get().getCategoryName());
            medicineResponseDtoList.add(medicineResponseDto);
        }
        return medicineResponseDtoList;
    }

//    @Override
//    public List<MedicineResponseDto> getOutOfStockMedicineList(){
//        List<MedicineResponseDto> medicineResponseDtoList = getMedicineList();
//        List<MedicineResponseDto> outOfStockMedicineResponseDtoList = new ArrayList<>();
//        for(MedicineResponseDto medicineResponseDto: medicineResponseDtoList)
//        {
//            if(medicineResponseDto.getIsInStock()==false) outOfStockMedicineResponseDtoList.add(medicineResponseDto);
//        }
//        return outOfStockMedicineResponseDtoList;
//
//    }
//
//    @Override
//    public List<MedicineResponseDto> getExpiredMedicineList() throws Exception{
//        List<MedicineResponseDto> medicineResponseDtoList = getMedicineList();
//        List<MedicineResponseDto> expiredMedicineList = new ArrayList<>();
//
//        for(MedicineResponseDto medicineResponseDto: medicineResponseDtoList)
//        {
//            String sExp = medicineResponseDto.getExpiryDate().toString().substring(0,10);
//            Date exp = new SimpleDateFormat("yyyy-MM-dd").parse(sExp);
//
//            String sToday = java.time.LocalDate.now().toString().substring(0,10);
//            Date today = new SimpleDateFormat("yyyy-MM-dd").parse(sToday);
//            if(today.getTime()>exp.getTime())
//            {
//                expiredMedicineList.add(medicineResponseDto);
//            }
//
//        }
//        return expiredMedicineList;
//    }

    @Override
    public List<MedicineResponseDto> getMedicineToOrder() {
        List<Medicine> medicineListToOrder = medicineRepository.getMedicineToOrder();
        List<MedicineResponseDto> medicineResponseDtoList = new ArrayList<>();
        for(Medicine medicine : medicineListToOrder){
            MedicineResponseDto responseDto = new MedicineResponseDto();
            BeanUtils.copyProperties(medicine,responseDto);
            medicineResponseDtoList.add(responseDto);
        }
        return medicineResponseDtoList;
    }

    //    @Override
//    public List<MedicineResponseDto> getOutOfStock_Or_ExpiredMedicineList() {
//        HashSet<MedicineResponseDto> medicineResponseDtoHashSet = new HashSet<>();
//
//        List<MedicineResponseDto> outOfStockMedicineList = getOutOfStockMedicineList();
//        for(MedicineResponseDto outOfStockMedicine: outOfStockMedicineList)
//        {
//            medicineResponseDtoHashSet.add(outOfStockMedicine);
//        }
//
//        List<MedicineResponseDto> expiredMedicineList = new ArrayList<>();
//        try
//        {
//            expiredMedicineList = getExpiredMedicineList();
//            for(MedicineResponseDto expiredMedicine: expiredMedicineList)
//            {
//                medicineResponseDtoHashSet.add(expiredMedicine);
//            }
//        }
//        catch(Exception e)
//        {
//            System.out.println(e);
//        }
//
//        //return new ArrayList<>(medicineResponseDtoHashSet);
//        return ListUtils.intersection(outOfStockMedicineList, expiredMedicineList);
//
//    }

//    @Override
//    public MedicineResponseDto updateAvailability(Long medicineId, MedicineRequestDto medicineRequestDto){
//
//        MedicineResponseDto medicineResponseDto = getMedicineById(medicineId);
//        if(medicineResponseDto.getTotalQuantity() == 0 && medicineResponseDto.getIsInStock() == true)
//        {
//            medicineResponseDto.setIsInStock(false);
//        }
//        if(medicineResponseDto.getTotalQuantity() > 0 && medicineResponseDto.getIsInStock() == false)
//        {
//            medicineResponseDto.setIsInStock(true);
//        }
//
//        Medicine medicine = new Medicine();
//        BeanUtils.copyProperties(medicineResponseDto, medicine);
//        medicineRepository.save(medicine);
//        return medicineResponseDto;
//    }


}
