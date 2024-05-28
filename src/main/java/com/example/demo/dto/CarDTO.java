package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class CarDTO {
    private String licensePlate;
    private LocalDate repairDate;
    private String customerName;
    private String catalogs;
    private String carMaker;
}
