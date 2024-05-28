package com.example.demo.controller;

import com.example.demo.dto.CarDTO;
import com.example.demo.dto.CarResponseDTO;
import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.ICarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    ICarService carService;

    public CarController(ICarService carService) {
        this.carService = carService;
    }

    @PostMapping("")
    public Car createCar(@RequestBody CarDTO car) {
        return this.carService.createCar(car);
    }
    @GetMapping("")
    public List<CarResponseDTO> createCar() {
        return this.carService.findAll();
    }
}
