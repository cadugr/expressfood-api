package com.cegrconsulting.expressfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cegrconsulting.expressfood.infrastructure.repository.CustomJpaRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class) //Desta forma estamos informando ao Spring que mudamos a implementação de nosso repositório base.
public class ExpressfoodApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpressfoodApiApplication.class, args);
	}

}
