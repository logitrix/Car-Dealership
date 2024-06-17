package com.pst.ag.car_dealership.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String modelName;

    // length in mm
    private BigDecimal length;

    // weight in kg
    private BigDecimal weight;

    // km per hr
    private BigDecimal velocity;

    private String color;
    public Car(String modelName, BigDecimal length, BigDecimal weight, BigDecimal velocity, String color) {
        this.modelName = modelName;
        this.length = length;
        this.weight = weight;
        this.velocity = velocity;
        this.color = color;
    }

}
