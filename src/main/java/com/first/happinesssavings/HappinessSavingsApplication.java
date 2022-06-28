package com.first.happinesssavings;

import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class HappinessSavingsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HappinessSavingsApplication.class, args);
    }

}
