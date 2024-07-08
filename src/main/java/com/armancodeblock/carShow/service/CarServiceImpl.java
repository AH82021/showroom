package com.armancodeblock.carShow.service;

import com.armancodeblock.carShow.entity.Car;
import com.armancodeblock.carShow.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getAllByMake(String make) {
        return carRepository.findCarByMake(make);
    }
}
