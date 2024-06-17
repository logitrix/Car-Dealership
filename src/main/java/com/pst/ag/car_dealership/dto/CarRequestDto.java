package com.pst.ag.car_dealership.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRequestDto {
    private String searchKey;
    private BigDecimal minLength;
    private BigDecimal maxLength;
    private BigDecimal minWeight;
    private BigDecimal maxWeight;
    private BigDecimal minVelocity;
    private BigDecimal maxVelocity;
    private List<String> colors = new ArrayList<>();
}
