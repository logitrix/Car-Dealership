package com.pst.ag.car_dealership.dto;

import com.pst.ag.car_dealership.entity.Car;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class FilterDto {
    private BigDecimal minLength;
    private BigDecimal maxLength;
    private BigDecimal minWeight;
    private BigDecimal maxWeight;
    private BigDecimal minVelocity;
    private BigDecimal maxVelocity;
    private List<String> colorsAvailable;

    public FilterDto(List<Car> cars) {
        /*length = cars.stream().map(Car::getLength).distinct().sorted().collect(Collectors.toList());
        weight = cars.stream().map(Car::getWeight).distinct().sorted().collect(Collectors.toList());
        velocity = cars.stream().map(Car::getVelocity).distinct().sorted().collect(Collectors.toList());*/
        if (cars != null && cars.size() > 0) {
            minLength = cars.stream().map(Car::getLength).min(BigDecimal::compareTo).get();
            maxLength = cars.stream().map(Car::getLength).max(BigDecimal::compareTo).get();
            minWeight = cars.stream().map(Car::getWeight).min(BigDecimal::compareTo).get();
            maxWeight = cars.stream().map(Car::getWeight).max(BigDecimal::compareTo).get();
            minVelocity = cars.stream().map(Car::getVelocity).min(BigDecimal::compareTo).get();
            maxVelocity = cars.stream().map(Car::getVelocity).max(BigDecimal::compareTo).get();
            colorsAvailable = cars.stream().map(Car::getColor).distinct().sorted().collect(Collectors.toList());
        }
    }
}
