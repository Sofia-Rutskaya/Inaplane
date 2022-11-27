package com.Airtickets.Inaplane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.Airtickets.Inaplane.persistence.entity")
@EnableJpaRepositories("com.Airtickets.Inaplane.persistence.repository")
public class InaplaneApplication {

	public static void main(String[] args) {

		SpringApplication.run(InaplaneApplication.class, args);

	}


}
