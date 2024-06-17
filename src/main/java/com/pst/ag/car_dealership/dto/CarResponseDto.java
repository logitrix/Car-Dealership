package com.pst.ag.car_dealership.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.pst.ag.car_dealership.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Data
@JacksonXmlRootElement(localName =  "body")
public class CarResponseDto {
    @JacksonXmlElementWrapper(localName = "cars")
    @JacksonXmlProperty(localName = "car")
    private List<Car> cars;
    private FilterDto availableFilters;
    private CarRequestDto request;

    public CarResponseDto(List<Car> carList, FilterDto availableFilters, CarRequestDto request) {
        this.cars = carList;
        this.availableFilters = availableFilters;
        this.request = request;
    }
}
