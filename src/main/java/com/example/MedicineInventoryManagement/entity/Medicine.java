package com.example.MedicineInventoryManagement.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter

public class Medicine {

    @Id
    @GenericGenerator(name = "id_seq", strategy = "increment")
    @GeneratedValue(generator = "id_seq", strategy = GenerationType.AUTO)
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


}
