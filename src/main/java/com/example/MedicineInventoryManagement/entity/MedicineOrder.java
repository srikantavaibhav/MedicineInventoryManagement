package com.example.MedicineInventoryManagement.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class MedicineOrder {

    @Id
    @GenericGenerator(name = "id_seq", strategy = "increment")
    @GeneratedValue(generator = "id_seq", strategy = GenerationType.AUTO)
    private Integer orderId;
    private Integer medicineId;
    private Integer medicineQuantity;
    private Long totalAmount;
    private Date orderDate;

}
