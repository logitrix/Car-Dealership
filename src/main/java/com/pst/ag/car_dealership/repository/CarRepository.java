package com.pst.ag.car_dealership.repository;

import com.pst.ag.car_dealership.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>, CarRepositoryCustom{}