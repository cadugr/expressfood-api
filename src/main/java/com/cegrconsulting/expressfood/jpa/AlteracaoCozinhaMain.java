package com.cegrconsulting.expressfood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.cegrconsulting.expressfood.ExpressfoodApiApplication;
import com.cegrconsulting.expressfood.domain.model.Cozinha;

public class AlteracaoCozinhaMain {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new SpringApplicationBuilder(ExpressfoodApiApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);

    CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
    
    Cozinha cozinha = new Cozinha();
    cozinha.setId(1L);
    cozinha.setNome("Brasileira");

    cozinha = cadastroCozinha.salvar(cozinha);
  
    System.out.printf("%d - %s\n", cozinha.getId(), cozinha.getNome());
    
  }
  
}
