package com.example.demo.service.impl;

import com.example.demo.dto.AccessoryResponseDTO;
import com.example.demo.dto.CarDTO;
import com.example.demo.dto.CarResponseDTO;
import com.example.demo.entity.Accessory;
import com.example.demo.entity.Car;
import com.example.demo.entity.CarId;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.ICarService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements ICarService {
    CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car createCar(CarDTO carDTO) {
        CarId carId = new CarId();
        carId.setRepairDate(carDTO.getRepairDate());
        carId.setLicensePlate(carDTO.getLicensePlate());
        Car car = new Car();
        car.setCarId(carId);
        car.setCarMaker(carDTO.getCarMaker());
        car.setCatalogs(carDTO.getCatalogs());
        car.setCustomerName(carDTO.getCustomerName());
        return this.carRepository.save(car);
    }

    @Override
    public List<CarResponseDTO> findAll() {
        List<Car> cars = this.carRepository.findAll();
        List<CarResponseDTO> carResponseDTOS = new ArrayList<>();
        for (Car car : cars) {
            CarResponseDTO carResponseDTO = new CarResponseDTO();
            carResponseDTO.setLicensePlate(car.getCarId().getLicensePlate());
            carResponseDTO.setRepairDate(car.getCarId().getRepairDate());
            carResponseDTO.setCarMaker(car.getCarMaker());
            carResponseDTO.setCatalogs(car.getCatalogs());
            carResponseDTO.setCustomerName(car.getCustomerName());

            List<AccessoryResponseDTO> accessoryResponseDTOS = new ArrayList<>();
            for (Accessory accessory : car.getAccessories()){
                AccessoryResponseDTO accessoryResponseDTO = new AccessoryResponseDTO();
                accessoryResponseDTO.setId(accessory.getId());
                accessoryResponseDTO.setName(accessory.getName());
                accessoryResponseDTO.setPrice(accessory.getPrice());
                accessoryResponseDTO.setRepairStatus(accessory.getRepairStatus());
                accessoryResponseDTO.setStatusDamaged(accessory.getStatusDamaged());
                accessoryResponseDTOS.add(accessoryResponseDTO);
            }
            carResponseDTO.setAccessories(accessoryResponseDTOS);
            carResponseDTOS.add(carResponseDTO);

        }
        return carResponseDTOS;
    }
}
