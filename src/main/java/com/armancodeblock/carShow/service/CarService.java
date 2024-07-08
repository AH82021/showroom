package com.armancodeblock.carShow.service;

import com.armancodeblock.carShow.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();

    List<Car> getAllByMake(String make);
}
