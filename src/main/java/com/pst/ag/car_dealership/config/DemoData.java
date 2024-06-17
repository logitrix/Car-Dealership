package com.pst.ag.car_dealership.config;

import com.pst.ag.car_dealership.entity.Car;
import com.pst.ag.car_dealership.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DemoData {
    @Autowired
    private CarRepository repo;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        System.out.println("Demo Data Initializing...");
        repo.save(new Car("BMW iX", BigDecimal.valueOf(4938), BigDecimal.valueOf(3200), BigDecimal.valueOf(160), "RED"));
        repo.save(new Car("Mitsubishi Montero Sport", BigDecimal.valueOf(4825), BigDecimal.valueOf(2710), BigDecimal.valueOf(180), "DIAMOND_WHITE"));
        repo.save(new Car("Toyota Fortuner ", BigDecimal.valueOf(4900), BigDecimal.valueOf(4795), BigDecimal.valueOf(160), "BLACK"));
        repo.save(new Car("Nissan Terra ", BigDecimal.valueOf(4900), BigDecimal.valueOf(2610), BigDecimal.valueOf(170), "DIAMOND_WHITE"));
        repo.save(new Car("Mercedes-Benz G-Class", BigDecimal.valueOf(4817), BigDecimal.valueOf(3715), BigDecimal.valueOf(190), "BLUE"));
        repo.save(new Car("Volkswagen Tharu", BigDecimal.valueOf(4458), BigDecimal.valueOf(2350), BigDecimal.valueOf(140), "LIGHT_BLUE"));
        repo.save(new Car("Honda CR-V", BigDecimal.valueOf(4691), BigDecimal.valueOf(2689), BigDecimal.valueOf(170), "BLUE"));
        repo.save(new Car("Chevrolet Suburban", BigDecimal.valueOf(5733), BigDecimal.valueOf(2642), BigDecimal.valueOf(180), "BLACK"));
        repo.save(new Car("Audi Q7", BigDecimal.valueOf(5063), BigDecimal.valueOf(3451), BigDecimal.valueOf(190), "LIGHT_BLUE"));
        repo.save(new Car("Lexus GX", BigDecimal.valueOf(4805), BigDecimal.valueOf(2900), BigDecimal.valueOf(160), "DIAMOND_WHITE"));
        repo.save(new Car("Jeep Grand Cherokee L", BigDecimal.valueOf(5204), BigDecimal.valueOf(3230), BigDecimal.valueOf(160), "DIAMOND_WHITE"));
        repo.save(new Car("Land Rover Defender 110", BigDecimal.valueOf(4758), BigDecimal.valueOf(2186), BigDecimal.valueOf(170), "DIAMOND_WHITE"));
    }
}
