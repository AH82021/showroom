package com.armancodeblock.carShow;


import com.armancodeblock.carShow.entity.Car;
import com.armancodeblock.carShow.entity.Owner;
import com.armancodeblock.carShow.repository.CarRepository;
import com.armancodeblock.carShow.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;


// @EnableAutoConfiguration
/*
This enables Spring Boot automatic configuration.Spring Boot will automatically configure your
 project based on the dependencies. For example, if you have the spring-boot-starter-web dependency,
  Spring Boot assumes that you are developing a web application and configures your application accordingly.
 */
//@ComponentScan
//@Configuration
//@ComponentScan(basePackages = "demo.carShow",
//		includeFilters = @ComponentScan.Filter(Service.class),
//		excludeFilters = @ComponentScan.Filter(Configuration.class)
//)
//@Configuration
//@EnableAutoConfiguration
@SpringBootApplication
public class CarShowRoomApplication implements CommandLineRunner {

	private final CarRepository carRepository;
	private final OwnerRepository ownerRepository;

 private static final Logger logger = LoggerFactory.getLogger(CarShowRoomApplication.class);

    public CarShowRoomApplication(CarRepository carRepository, OwnerRepository ownerRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(
				CarShowRoomApplication.class, args);
		logger.info("Application started");
//		logger.warn("Do your project please ");
//		logger.error("Faraz where is Pakora");

	}


	@Override
	public void run(String... args) throws Exception {

	Owner owner1 = new Owner("John", "Biden");
	Owner owner2 = new Owner("Donald","Trump");

	ownerRepository.save(owner1);
	ownerRepository.save(owner2);




		List<Car> carList = Arrays.asList(
				new Car("Ford","Mustang","Red","FM_23434",2022,48000,owner1),
				new Car("Toyota","Highlander","White","TH_12435",2023,52000,owner2),
				new Car("Toyota","Camry","Black","TC_33444",2023,37000,owner2),
				new Car("Tesla","Model Y","Red","TX_35634",2024,98000,owner1),
				new Car("Benz","C-150","Gray","BC_89767",2024,148000,owner2)

		);
		carRepository.saveAll(carList);

		for (Car car : carRepository.findAll()) {
			logger.info(car.getMake() + " "+ car.getModel());
		}
	}
}
