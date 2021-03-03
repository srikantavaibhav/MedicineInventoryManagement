package com.example.MedicineInventoryManagement.service.Impl;

import com.example.MedicineInventoryManagement.dto.MedicineRequestDto;
import com.example.MedicineInventoryManagement.dto.MedicineResponseDto;
import com.example.MedicineInventoryManagement.entity.Medicine;
import com.example.MedicineInventoryManagement.repository.MedicineRepository;
import com.example.MedicineInventoryManagement.service.MedicineService;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

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

        return medicineResponseDto;
    }

    @Override
    public MedicineResponseDto getMedicineById(Long medicineId) {
        Optional<Medicine> medicineOptional = medicineRepository.findById(medicineId);
        if (medicineOptional.isPresent()) {
            MedicineResponseDto medicineResponseDto = new MedicineResponseDto();
            BeanUtils.copyProperties(medicineOptional.get(), medicineResponseDto);
            return medicineResponseDto;
        }
        return null;
    }

    @Override
    public MedicineResponseDto updateMedicineById(Long medicineId, MedicineRequestDto medicineRequestDto) {

        if(medicineRequestDto.getTotalQuantity() == 0 && medicineRequestDto.getIsInStock() == true)
        {
            medicineRequestDto.setIsInStock(false);
        }
        if(medicineRequestDto.getTotalQuantity() > 0 && medicineRequestDto.getIsInStock() == false)
        {
            medicineRequestDto.setIsInStock(true);
        }


        Optional<Medicine> medicineOptional = medicineRepository.findById(medicineId);
        if (medicineOptional.isPresent()) {
            Medicine medicineFromDb = medicineOptional.get();
            BeanUtils.copyProperties(medicineRequestDto, medicineFromDb);

            Medicine savedMedicine = medicineRepository.save(medicineFromDb);
            MedicineResponseDto medicineResponseDto = new MedicineResponseDto();
            BeanUtils.copyProperties(savedMedicine, medicineResponseDto);
            return medicineResponseDto;
        }
        return null;
    }

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
