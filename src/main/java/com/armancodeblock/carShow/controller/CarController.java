package com.armancodeblock.carShow.controller;

import com.armancodeblock.carShow.entity.Car;
import com.armancodeblock.carShow.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping("/{make}")
    public ResponseEntity<List<Car>> getCarListByMake(@PathVariable String make){
        return new ResponseEntity<>(carService.getAllByMake(make), HttpStatus.OK);
    }
}
