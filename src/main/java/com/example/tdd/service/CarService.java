package com.example.tdd.service;

import com.example.tdd.domain.Car;
import com.example.tdd.repository.CarRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public Car getCarDetails(String name) {
        return carRepository.findByName(name);
    }
}
