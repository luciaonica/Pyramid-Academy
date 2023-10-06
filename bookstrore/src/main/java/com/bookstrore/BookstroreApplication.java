package com.bookstrore;

import jakarta.persistence.EntityManager;
import org.hibernate.engine.spi.SessionLazyDelegator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstroreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstroreApplication.class, args);
	}


}
