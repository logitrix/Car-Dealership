package com.pst.ag.car_dealership.service;

import com.pst.ag.car_dealership.dto.CarRequestDto;
import com.pst.ag.car_dealership.dto.CarResponseDto;
import com.pst.ag.car_dealership.dto.FilterDto;
import com.pst.ag.car_dealership.entity.Car;
import com.pst.ag.car_dealership.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public CarResponseDto search(CarRequestDto dto, boolean withFilter) throws Exception {

        if(dto.getSearchKey() == null){
            dto.setSearchKey("");
        }

        if (dto.getMinLength() != null && dto.getMaxLength() != null) {
            if(dto.getMinLength().compareTo(dto.getMaxLength()) == 1){
                throw new Exception("Min length should be less than max length");
            }
        } else {
            dto.setMinLength(BigDecimal.ZERO);
            dto.setMaxLength(BigDecimal.ZERO);
        }

        if (dto.getMinWeight() != null && dto.getMaxWeight() != null) {
            if (dto.getMinWeight().compareTo(dto.getMaxWeight()) == 1) {
                throw new Exception("Min weight should be less than max weight");
            }
        } else {
            dto.setMinWeight(BigDecimal.ZERO);
            dto.setMaxWeight(BigDecimal.ZERO);
        }

        if (dto.getMinVelocity() != null && dto.getMaxVelocity() != null) {
            if(dto.getMinVelocity().compareTo(dto.getMaxVelocity()) == 1){
                throw new Exception("Min velocity should be less than max velocity");
            }
        } else {
            dto.setMinVelocity(BigDecimal.ZERO);
            dto.setMaxVelocity(BigDecimal.ZERO);
        }

        List<Car> cars = carRepository.findCarsByRequest(dto);

        if (withFilter) {
            return new CarResponseDto(cars, new FilterDto(carRepository.findAll()), dto);
        } else {
            return new CarResponseDto(cars, null, null);
        }
    }

    public CarResponseDto searchAll() {
        List<Car> cars = (List<Car>) carRepository.findAll();
        return new CarResponseDto(cars, new FilterDto(cars), new CarRequestDto());
    }
}
