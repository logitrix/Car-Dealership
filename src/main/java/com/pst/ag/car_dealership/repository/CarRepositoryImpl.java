package com.pst.ag.car_dealership.repository;

import com.pst.ag.car_dealership.dto.CarRequestDto;
import com.pst.ag.car_dealership.entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Car> findCarsByRequest(CarRequestDto carRequestDto) {
        String query = "select c " +
                "from Car c " +
                "where UPPER(c.modelName) like concat('%', :searchKey, '%') " +
                (carRequestDto.getMinLength().compareTo(BigDecimal.ZERO) > 0 && carRequestDto.getMaxLength().compareTo(BigDecimal.ZERO) > 0 ?
                        "and (c.length >=  :minLength and c.length <= :maxLength) " : "" ) +
                (carRequestDto.getMinWeight().compareTo(BigDecimal.ZERO) > 0 && carRequestDto.getMaxWeight().compareTo(BigDecimal.ZERO) > 0 ?
                        "and (c.weight >=  :minWeight and c.weight <= :maxWeight) " : "" ) +
                (carRequestDto.getMinVelocity().compareTo(BigDecimal.ZERO) > 0 && carRequestDto.getMaxVelocity().compareTo(BigDecimal.ZERO) > 0 ?
                        "and (c.velocity >=  :minVelocity and c.velocity <= :maxVelocity) " : "" ) +
                (carRequestDto.getColors() != null && carRequestDto.getColors().size() > 0 ? "and c.color in :color " : "" );

        TypedQuery<Car> carsQuery =  entityManager.createQuery(query, Car.class)
                .setParameter("searchKey", carRequestDto.getSearchKey().toUpperCase());

        if (carRequestDto.getColors() != null && carRequestDto.getColors().size() > 0 ) {
            carsQuery .setParameter("color", carRequestDto.getColors());
        }

        if (carRequestDto.getMinLength().compareTo(BigDecimal.ZERO) > 0 && carRequestDto.getMaxLength().compareTo(BigDecimal.ZERO) > 0 ) {
            carsQuery.setParameter("minLength", carRequestDto.getMinLength())
                    .setParameter("maxLength", carRequestDto.getMaxLength());
        }

        if (carRequestDto.getMinWeight().compareTo(BigDecimal.ZERO) > 0 && carRequestDto.getMaxWeight().compareTo(BigDecimal.ZERO) > 0 ) {
            carsQuery.setParameter("minWeight", carRequestDto.getMinWeight())
                    .setParameter("maxWeight", carRequestDto.getMaxWeight());
        }

        if (carRequestDto.getMinVelocity().compareTo(BigDecimal.ZERO) > 0 && carRequestDto.getMaxVelocity().compareTo(BigDecimal.ZERO) > 0 ) {
            carsQuery.setParameter("minVelocity", carRequestDto.getMinVelocity())
                    .setParameter("maxVelocity", carRequestDto.getMaxVelocity());
        }

        return carsQuery.getResultList();
    }
}