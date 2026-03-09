package com.cg.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="product_table")
@Data

public class Product {
    @Id

    private int pid;
    private String name;
    private int qty;
    private double price;
    private LocalDate mfd;


}
