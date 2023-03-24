package com.cegrconsulting.expressfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.cegrconsulting.expressfood.ExpressfoodApiApplication;
import com.cegrconsulting.expressfood.domain.model.Restaurante;
import com.cegrconsulting.expressfood.domain.repository.RestauranteRepository;

public class ConsultaRestauranteMain {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new SpringApplicationBuilder(ExpressfoodApiApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);

    RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);
    
    List<Restaurante> todosRestaurantes = restaurantes.todos();

    for(Restaurante restaurante: todosRestaurantes) {
      System.out.printf("Restaurante %s - Taxa frete: %.2f - Cozinha: %s\n", restaurante.getNome(), restaurante.getTaxaFrete(), restaurante.getCozinha().getNome());
    }
  }
  
}
