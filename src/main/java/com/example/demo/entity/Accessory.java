package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    private double price;
    private String statusDamaged;
    private String repairStatus;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "license_plate", referencedColumnName = "licensePlate"),
            @JoinColumn(name = "repair_date", referencedColumnName = "repairDate")
    })
    private Car car;

}
