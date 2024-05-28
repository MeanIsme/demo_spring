package com.example.demo.service.impl;

import com.example.demo.dto.AccessoryDTO;
import com.example.demo.dto.AccessoryResponseDTO;
import com.example.demo.entity.Accessory;
import com.example.demo.entity.Car;
import com.example.demo.repository.AccessoryRepository;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.IAccessoryService;
import org.springframework.stereotype.Service;

@Service

public class AccessoryServiceImpl implements IAccessoryService {
    AccessoryRepository accessoryRepository;
    CarRepository carRepository;

    public AccessoryServiceImpl(AccessoryRepository accessoryRepository, CarRepository carRepository) {
        this.accessoryRepository = accessoryRepository;
        this.carRepository = carRepository;
    }

    @Override
    public AccessoryResponseDTO createAccessory(AccessoryDTO accessoryDTO) {
        Accessory accessory = createAccessoryEntity(accessoryDTO);
        accessory = this.accessoryRepository.save(accessory);
        return createAccessoryResponseDTO(accessory);
    }

    private Accessory createAccessoryEntity(AccessoryDTO accessoryDTO) {
        Accessory accessory = new Accessory();
        accessory.setName(accessoryDTO.getName());
        accessory.setPrice(accessoryDTO.getPrice());
        accessory.setRepairStatus(accessoryDTO.getRepairStatus());
        accessory.setStatusDamaged(accessoryDTO.getStatusDamaged());
        Car car = carRepository.findByCarIdLicensePlateAndCarIdRepairDate(accessoryDTO.getLicensePlate(),accessoryDTO.getRepairDate());
        accessory.setCar(car);
        return accessory;
    }

    private AccessoryResponseDTO createAccessoryResponseDTO(Accessory accessory) {
        AccessoryResponseDTO accessoryResponseDTO = new AccessoryResponseDTO();
        accessoryResponseDTO.setId(accessory.getId());
        accessoryResponseDTO.setName(accessory.getName());
        accessoryResponseDTO.setPrice(accessory.getPrice());
        accessoryResponseDTO.setRepairStatus(accessory.getRepairStatus());
        accessoryResponseDTO.setStatusDamaged(accessory.getStatusDamaged());
        return accessoryResponseDTO;
    }

    @Override
    public AccessoryResponseDTO editAccessory(AccessoryDTO accessoryDTO) {
        Accessory accessory = accessoryRepository.findById(accessoryDTO.getId()).orElse(null);
        if (accessory != null) {
            if (accessoryDTO.getRepairStatus()!= null)
                accessory.setRepairStatus(accessoryDTO.getRepairStatus());
            if (accessoryDTO.getStatusDamaged()!= null)
                accessory.setStatusDamaged(accessoryDTO.getStatusDamaged());
            if (accessoryDTO.getPrice()!= null)
                accessory.setPrice(accessoryDTO.getPrice());
            if (accessoryDTO.getName()!= null)
                accessory.setName(accessoryDTO.getName());
            accessory = this.accessoryRepository.save(accessory);
            return createAccessoryResponseDTO(accessory);
        }
        return null;
    }

    @Override
    public void deleteAccessory(Long id) {
        this.accessoryRepository.deleteById(id);
    }
}
