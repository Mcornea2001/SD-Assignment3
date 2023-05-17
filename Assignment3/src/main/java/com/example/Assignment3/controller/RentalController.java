package com.example.Assignment3.controller;

import com.example.Assignment3.Service.AdminService;
import com.example.Assignment3.Service.RentalService;
import com.example.Assignment3.model.Admin;
import com.example.Assignment3.model.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rental")
public class RentalController {
    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/all")
    public List<Rental> getRental() {
        return rentalService.getRental();
    }

    @PostMapping("/add")
    public void registerNewRental(@RequestBody Rental rental) {
        rentalService.addNewRental(rental);
    }

    @DeleteMapping(path = "/delete/{rentalId}")
    public void deleteRental(@PathVariable("rentalId") Long rentalId) {
        rentalService.deleteRental(rentalId);
    }

    @PutMapping(path = "/update/{rentalId}")
    public void updateRental(
            @PathVariable("rentalId") Long rentalId,
            @RequestParam(required = false) Long carId,
            @RequestParam(required = false) Long customerId,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String period) {
        rentalService.updateRental(rentalId, carId, customerId, price, period);
    }
}
