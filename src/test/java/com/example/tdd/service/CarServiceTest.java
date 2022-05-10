package com.example.tdd.service;

import com.example.tdd.domain.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class CarServiceTest {
    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @BeforeEach
    public void setUp() throws Exception {
        carService = new CarService(carRepository);
    }

    @Test
    void getCarDetails_returnsCarInfo() {
        given(carRepository.findByName("prius")).willReturn(new Car("prius", "hybrid"));

        Car car = carService.getCarDetails("prius");

        Assertions.assertEquals("prius", car.getName());
        Assertions.assertEquals("hybrid", car.getType());
    }
}