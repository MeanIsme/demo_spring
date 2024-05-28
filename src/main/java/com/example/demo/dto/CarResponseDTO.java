package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CarResponseDTO {
    private String licensePlate;
    private LocalDate repairDate;
    private String customerName;
    private String catalogs;
    private String carMaker;
    private List<AccessoryResponseDTO> accessories;
}
