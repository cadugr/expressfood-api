package com.cegrconsulting.expressfood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.cegrconsulting.expressfood.ExpressfoodApiApplication;
import com.cegrconsulting.expressfood.domain.model.Cozinha;
import com.cegrconsulting.expressfood.domain.repository.CozinhaRepository;

public class InclusaoCozinhaMain {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new SpringApplicationBuilder(ExpressfoodApiApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);

    CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);
    
    Cozinha cozinha1 = new Cozinha();
    cozinha1.setNome("Brasileira");

    Cozinha cozinha2 = new Cozinha();
    cozinha2.setNome("Japonesa");

    cozinha1 = cozinhas.salvar(cozinha1);
    cozinha2 = cozinhas.salvar(cozinha2);

    System.out.printf("%d - %s\n", cozinha1.getId(), cozinha1.getNome());
    System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome());
    
  }
  
}
