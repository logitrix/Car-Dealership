package com.pst.ag.car_dealership.contoller;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.pst.ag.car_dealership.dto.CarRequestDto;
import com.pst.ag.car_dealership.dto.CarResponseDto;
import com.pst.ag.car_dealership.service.CarService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;


@Controller
public class AppController {

    @Autowired
    private CarService carService;

    @RequestMapping(path = {"/search"})
    public String home(CarRequestDto carDto, Model model, @RequestParam(required = false) String action, HttpServletResponse response) throws Exception {
        if (action != null && action.equalsIgnoreCase("search")) {
            try {
                CarResponseDto dto = carService.search(carDto, true);
                model.addAttribute("response", dto);
            } catch (Exception e) {
                CarResponseDto dto = carService.searchAll();
                dto.setCars(null);
                model.addAttribute("response", dto);
            }
        } else if (action != null && action.equalsIgnoreCase("export")) {
            try {
                CarResponseDto dto = carService.search(carDto, false);
                String xmlObj = new XmlMapper().writeValueAsString(dto);
                InputStream is = new ByteArrayInputStream(xmlObj.getBytes(StandardCharsets.UTF_8));
                org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
                response.setContentType("application/xml");
                response.getOutputStream().flush();
                response.getOutputStream().close();
                return null;
            } catch (Exception e) {

                System.out.println("error here");

                CarResponseDto dto = carService.searchAll();
                dto.setCars(null);
                model.addAttribute("response", dto);
            }
        } else {
            CarResponseDto dto = carService.searchAll();
            dto.setRequest(new CarRequestDto());
            model.addAttribute("response", dto);
        }
        return "index";
    }
}
