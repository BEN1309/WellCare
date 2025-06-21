package org.wellcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "org.wellcare")
@EnableJpaRepositories("org.wellcare.repository")
@EntityScan("org.wellcare.model")
public class WellcareApplication {

	public static void main(String[] args) {
		SpringApplication.run(WellcareApplication.class, args);
		System.out.println("Application Started");
	}

}
