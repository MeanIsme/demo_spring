package com.example.demo.service;

import com.example.demo.dto.AccessoryDTO;
import com.example.demo.dto.AccessoryResponseDTO;
import com.example.demo.entity.Accessory;
import com.example.demo.entity.Car;

public interface IAccessoryService {
    AccessoryResponseDTO createAccessory(AccessoryDTO accessoryDTO);

    AccessoryResponseDTO editAccessory(AccessoryDTO accessory);

    void deleteAccessory(Long id);
}
