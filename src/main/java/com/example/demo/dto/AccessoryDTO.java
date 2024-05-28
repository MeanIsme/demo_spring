package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class AccessoryDTO {
    private long id;
    private String licensePlate;
    private LocalDate repairDate;
    private String name;
    private Double price;
    private String statusDamaged;
    private String repairStatus;
}
