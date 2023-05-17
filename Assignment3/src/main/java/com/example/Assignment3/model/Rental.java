package com.example.Assignment3.model;

import jakarta.persistence.*;

@Entity
@Table
public class Rental {
    @Id
    @SequenceGenerator(name = "rental_sequence",
            sequenceName = "rental_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "reantal_sequence"
    )
    private Long id;
    private Long carId;
    private Long customerId;
    private double price;
    private String period;

    public Rental(){}
    public Rental(Long id, Long carId, Long customerId, double price, String period) {
        this.id = id;
        this.carId = carId;
        this.customerId = customerId;
        this.price = price;
        this.period = period;
    }

    public Rental(Long carId, Long customerId, double price, String period) {
        this.carId = carId;
        this.customerId = customerId;
        this.price = price;
        this.period = period;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
