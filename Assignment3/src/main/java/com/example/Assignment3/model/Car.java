package com.example.Assignment3.model;

import jakarta.persistence.*;

@Entity
@Table
public class Car {
    @Id
    @SequenceGenerator(name = "car_sequence",
            sequenceName = "car_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "car_sequence"
    )
    private Long id;
    private String brand;
    private String model;
    private int km;

    public Car(){}
    public Car(Long id, String brand, String model, int km) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.km = km;
    }

    public Car(String brand, String model, int km) {
        this.brand = brand;
        this.model = model;
        this.km = km;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
}
