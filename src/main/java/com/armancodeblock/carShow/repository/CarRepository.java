package com.armancodeblock.carShow.repository;

import com.armancodeblock.carShow.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    List<Car> findCarByMake(String make);
    //List<Car> findCarByMakeAndModel(String make, String model);
}
