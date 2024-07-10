package com.armancodeblock.carShow.service;

import com.armancodeblock.carShow.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();

    List<Car> getAllByMake(String make);

    Car getCarById(Long id);
    Car saveCar(Car car);
    void deleteCarById(Long id);

    Car updateCarById(Long id,Car newCar);
}
