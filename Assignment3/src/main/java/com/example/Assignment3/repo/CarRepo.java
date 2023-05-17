package com.example.Assignment3.repo;

import com.example.Assignment3.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CarRepo extends  JpaRepository<Car, Long>{
}
