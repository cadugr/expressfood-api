package com.cegrconsulting.expressfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.cegrconsulting.expressfood.ExpressfoodApiApplication;
import com.cegrconsulting.expressfood.domain.model.Cozinha;
import com.cegrconsulting.expressfood.domain.repository.CozinhaRepository;

public class ConsultaCozinhaMain {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new SpringApplicationBuilder(ExpressfoodApiApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);

    CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);
    
    List<Cozinha> todasCozinhas = cozinhas.todas();

    for(Cozinha cozinha: todasCozinhas) {
      System.out.println(cozinha.getNome());
    }
  }
  
}
