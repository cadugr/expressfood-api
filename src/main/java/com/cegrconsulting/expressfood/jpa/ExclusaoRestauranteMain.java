package com.cegrconsulting.expressfood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.cegrconsulting.expressfood.ExpressfoodApiApplication;
import com.cegrconsulting.expressfood.domain.model.Restaurante;
import com.cegrconsulting.expressfood.domain.repository.RestauranteRepository;

public class ExclusaoRestauranteMain {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new SpringApplicationBuilder(ExpressfoodApiApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);

    RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);
    
    Restaurante restaurante = new Restaurante();
    restaurante.setId(1L);
    
    restaurantes.remover(restaurante);
    
  }
  
}
