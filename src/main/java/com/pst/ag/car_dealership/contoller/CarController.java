package com.pst.ag.car_dealership.contoller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.pst.ag.car_dealership.dto.CarRequestDto;
import com.pst.ag.car_dealership.dto.CarResponseDto;
import com.pst.ag.car_dealership.entity.Car;
import com.pst.ag.car_dealership.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/find-by")
    public ResponseEntity<Object> searchCars(@RequestBody CarRequestDto carDto) throws Exception {
        try {
            return success(carService.search(carDto, true));
        } catch (Exception e) {
            return fail(e.getMessage());
        }
    }

    @GetMapping("/find-all")
    public ResponseEntity<Object> searchAllCars() {
        return success(carService.searchAll());
    }

    @GetMapping("/export")
    public String exportCars(@RequestBody CarRequestDto carDto) throws Exception {
        try {
            return marshal(carService.search(carDto, false));
        } catch (Exception e) {
            return fail(e.getMessage()).toString();
        }
    }

    private ResponseEntity success(Object obj) {
            Map<String, Object> response = new HashMap<>();
            response.put("response", obj);
            return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private ResponseEntity fail(String errorMessage) {
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String marshal(Object obj) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.writeValueAsString(obj);
    }
}
