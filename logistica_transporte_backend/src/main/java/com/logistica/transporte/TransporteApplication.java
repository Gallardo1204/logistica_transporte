package com.logistica.transporte;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TransporteApplication {

    @Value("${validation.password.pattern}")
    private String passwordRegexp;

    public static void main(String[] args) {
        SpringApplication.run(TransporteApplication.class, args);
    }

    @PostConstruct
    public void setProperty() {
        System.setProperty("validation.password.pattern", passwordRegexp);
    }

}