package com.armancodeblock.carShow;


import com.armancodeblock.carShow.entity.Car;
import com.armancodeblock.carShow.repository.CarRepository;
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

 private static final Logger logger = LoggerFactory.getLogger(CarShowRoomApplication.class);

    public CarShowRoomApplication(CarRepository carRepository) {
        this.carRepository = carRepository;
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
		List<Car> carList = Arrays.asList(
				new Car(),
				new Car()
		);
	}
}
