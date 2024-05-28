package com.example.demo.repository;

import com.example.demo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
    @Query("SELECT c FROM Car c WHERE c.carId.licensePlate = ?1 AND c.carId.repairDate = ?2")
    Car findByCarIdLicensePlateAndCarIdRepairDate(String licensePlate, LocalDate repairDate);

}
