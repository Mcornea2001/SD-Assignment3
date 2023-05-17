package com.example.Assignment3.controller;

import com.example.Assignment3.Service.CarService;
import com.example.Assignment3.Service.CustomerService;
import com.example.Assignment3.model.Car;
import com.example.Assignment3.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/car")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public List<Car> getCar() {
        return carService.getCar();
    }

    @PostMapping("/add")
    public void registerNewCar(@RequestBody Car car) {
        carService.addNewCar(car);
    }

    @DeleteMapping(path = "/delete/{carId}")
    public void deleteCar(@PathVariable("carId") Long carId) {
        carService.deleteCar(carId);
    }

    @PutMapping(path = "/update/{carId}")
    public void updateCar(
            @PathVariable("carId") Long carId,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Integer km) {
        carService.updateCar(carId, brand, model, km);
    }

    @GetMapping("/find/{carId}")
    public ResponseEntity<Car> getCarById(@PathVariable("carId") int id) {
        Car car = carService.findCarById(id);
        if (car != null) {
            return new ResponseEntity<>(car, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
