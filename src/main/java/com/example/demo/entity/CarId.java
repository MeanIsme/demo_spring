package com.example.demo.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarId implements Serializable {
    private String licensePlate;
    private LocalDate repairDate;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarId carId = (CarId) o;
        return Objects.equals(licensePlate, carId.licensePlate) && Objects.equals(repairDate, carId.repairDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate, repairDate);
    }
}
