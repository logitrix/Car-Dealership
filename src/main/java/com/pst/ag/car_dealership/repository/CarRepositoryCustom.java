package com.pst.ag.car_dealership.repository;

import com.pst.ag.car_dealership.dto.CarRequestDto;
import com.pst.ag.car_dealership.entity.Car;

import java.util.List;

public interface CarRepositoryCustom {

    public List<Car> findCarsByRequest(CarRequestDto carRequestDto);
}
