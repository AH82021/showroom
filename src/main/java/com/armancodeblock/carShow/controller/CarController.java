package com.armancodeblock.carShow.controller;

import com.armancodeblock.carShow.entity.Car;
import com.armancodeblock.carShow.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars(){

        return new ResponseEntity<>(carService.getAllCars(),HttpStatus.OK);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id){

        return new ResponseEntity<>(carService.getCarById(id),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Car> saveCar(@RequestBody  Car car){

        return new ResponseEntity<>(carService.saveCar(car),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car){

        return new ResponseEntity<>(carService.updateCarById(id,car),HttpStatus.ACCEPTED);
    }
 @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
     carService.deleteCarById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
