package com.example.tdd.service;

import com.example.tdd.domain.Car;
import com.example.tdd.exception.CarNotFoundException;
import com.example.tdd.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

        assertEquals("prius", car.getName());
        assertEquals("hybrid", car.getType());
    }

    @Test
    void getCarDetails_whenCarNotFound() throws Exception {
        given(carRepository.findByName("prius")).willReturn(null);

        assertThrows(CarNotFoundException.class, () -> carService.getCarDetails("prius"));
    }
}