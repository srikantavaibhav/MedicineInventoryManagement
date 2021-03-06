package com.example.MedicineInventoryManagement.dto;

import com.example.MedicineInventoryManagement.entity.Category;
import com.example.MedicineInventoryManagement.repository.CategoryRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Getter
@Setter
public class MedicineResponseDto {
    private Integer medicineId;
    private String medicineName;
    private Integer categoryId;
    private String manufacturer;
    private String formula;
    private Date mfdDate;
    private Date expiryDate;
    private String dosage;
    private Short quantity;
    private String unit;
    private Integer totalQuantity;
    private Integer costPerUnit;
    private Boolean isInStock;
    private String categoryName;

}
