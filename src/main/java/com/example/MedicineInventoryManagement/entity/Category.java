package com.example.MedicineInventoryManagement.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GenericGenerator(name = "id_seq", strategy = "increment")
    @GeneratedValue(generator = "id_seq", strategy = GenerationType.AUTO)
    private Integer categoryId;
    private String categoryName;
    private String location;

}
