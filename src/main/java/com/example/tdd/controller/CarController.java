package com.example.tdd.controller;

import com.example.tdd.domain.Car;
import com.example.tdd.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CarController {

    private final CarService carService;

    @GetMapping("/cars/{name}")
    private Car getCar(@PathVariable String name) {
        return carService.getCarDetails(name);
    }

}
