package com.example.tdd.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@ToString
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;

    public Car(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
