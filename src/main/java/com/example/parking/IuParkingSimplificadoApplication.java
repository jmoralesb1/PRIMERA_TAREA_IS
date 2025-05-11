package com.example.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.parking", "com.example.otherpackage"})
public class IuParkingSimplificadoApplication {
    public static void main(String[] args) {
        SpringApplication.run(IuParkingSimplificadoApplication.class, args);
    }
}