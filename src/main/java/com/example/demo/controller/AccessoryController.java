package com.example.demo.controller;

import com.example.demo.dto.AccessoryDTO;
import com.example.demo.dto.AccessoryResponseDTO;
import com.example.demo.entity.Accessory;
import com.example.demo.entity.Car;
import com.example.demo.service.IAccessoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accessory")
public class AccessoryController {
    IAccessoryService accessoryService;

    public AccessoryController(IAccessoryService accessoryService) {
        this.accessoryService = accessoryService;
    }

    @PostMapping("")
    public AccessoryResponseDTO createAccessory(@RequestBody AccessoryDTO accessory) {
        return this.accessoryService.createAccessory(accessory);
    }

    @PutMapping("")
    public AccessoryResponseDTO editAccessory(@RequestBody AccessoryDTO accessory) {
        return this.accessoryService.editAccessory(accessory);
    }
    @DeleteMapping("/{id}")
    public void deleteAccessory(@PathVariable Long id) {
        this.accessoryService.deleteAccessory(id);
    }

}
