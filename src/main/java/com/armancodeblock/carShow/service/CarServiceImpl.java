package com.armancodeblock.carShow.service;

import com.armancodeblock.carShow.entity.Car;
import com.armancodeblock.carShow.exception.ResourceNotFoundException;
import com.armancodeblock.carShow.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Car getCarById(Long id) {

//        Optional<Car> car = carRepository.findById(id);
//        if(car.isPresent()) {
//            return car.get();
//        }
//       throw new ResourceNotFoundException("Car with id " + id + " does not exist");

        Car car = carRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Car with id " + id + " does not exist"));

        return car;
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCarById(Long id) {

        carRepository.deleteById(id);

    }

    @Override
    public Car updateCarById(Long id, Car newCar) {
     Car car = getCarById(id);
     car.setMake(newCar.getMake());
     car.setModel(newCar.getModel());
     car.setColor(newCar.getColor());
     car.setPrice(newCar.getPrice());
     car.setYear(newCar.getYear());
     car.setRegisterNumber(newCar.getRegisterNumber());
     car.setOwner(newCar.getOwner());

   return   carRepository.save(car);



    }
}
