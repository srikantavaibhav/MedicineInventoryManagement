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
    private Long medicineId;
    private String medicineName;
    private Long categoryId;
    private String manufacturer;
    private String formula;
    private Date mfdDate;
    private Date expiryDate;
    private String dosage;
    private Long quantity;
    private String unit;
    private Long totalQuantity;
    private Long costPerUnit;
    private Boolean isInStock;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JsonBackReference
//    private Category category;

}
