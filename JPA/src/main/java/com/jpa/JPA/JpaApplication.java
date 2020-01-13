package com.jpa.JPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPu");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();

	//Init transaction
}
