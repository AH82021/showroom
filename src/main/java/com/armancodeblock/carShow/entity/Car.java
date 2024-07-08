package com.armancodeblock.carShow.entity;

import jakarta.persistence.*;

@Entity
public class Car {
@Id
// GenerationType.AUTO vs GenerationType.IDENTITY vs GenerationType.TABLE
@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "my_sequence")
@SequenceGenerator(name = "my_sequence",sequenceName = "my_sequence",
allocationSize = 5) // postgres or Oracle database
    private Long id;
    private String make;
    private String model;
    private String color;
    private String registerNumber;
    private int year;
    private double price;

    public Car() {
    }

    public Car(String make,
               String model,
               String color,
               String registerNumber,
               int year,
               double price) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
