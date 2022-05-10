package com.example.tdd.repository;

import com.example.tdd.domain.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CarRepositoryTest {
    @Autowired
    private CarRepository repository;
    
    @Autowired
    private TestEntityManager entityManager;

    @Test
    void getCar_returnsCarDetails() {
        Car car = repository.findByName("prius");

        assertEquals("prius", car.getName());
        assertEquals("hybrid", car.getType());
    }

    @Test
    void findByName_returnsCar() throws Exception {
        Car savedCar = entityManager.persistFlushFind(new Car("prius", "hybrid"));
        Car car = repository.findByName("prius");

        assertEquals(savedCar.getName(), car.getName());
        assertEquals(savedCar.getType(), car.getType());
    }
}