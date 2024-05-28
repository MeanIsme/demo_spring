package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @EmbeddedId
    private CarId carId;
    @Column(nullable = false)
    private String customerName;
    @Column(nullable = false)
    private String catalogs;
    @Column(nullable = false)
    private String carMaker;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Accessory> accessories = new ArrayList<>();
}
