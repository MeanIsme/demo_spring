package com.example.demo.service;

import com.example.demo.dto.CarDTO;
import com.example.demo.dto.CarResponseDTO;
import com.example.demo.entity.Car;

import java.util.List;

public interface ICarService {
    Car createCar(CarDTO car);
    List<CarResponseDTO> findAll();
}
