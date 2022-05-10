package com.example.tdd;

import com.example.tdd.domain.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testName() throws Exception {
        // arrange

        // act
        ResponseEntity<Car> response = restTemplate.getForEntity("/cars/prius", Car.class);

        // assert
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody().getName(), "prius");
        Assertions.assertEquals(response.getBody().getType(), "hybrid");
    }
}
