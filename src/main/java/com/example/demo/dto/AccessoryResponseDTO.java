package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AccessoryResponseDTO {
    private long id;
    private String name;
    private double price;
    private String statusDamaged;
    private String repairStatus;
}
