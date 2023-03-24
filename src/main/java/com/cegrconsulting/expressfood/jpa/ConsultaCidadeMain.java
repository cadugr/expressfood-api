package com.cegrconsulting.expressfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.cegrconsulting.expressfood.ExpressfoodApiApplication;
import com.cegrconsulting.expressfood.domain.model.Cidade;
import com.cegrconsulting.expressfood.domain.repository.CidadeRepository;

public class ConsultaCidadeMain {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new SpringApplicationBuilder(ExpressfoodApiApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);

    CidadeRepository cidades = applicationContext.getBean(CidadeRepository.class);
    
    List<Cidade> todasCidades = cidades.todas();

    for(Cidade cidade: todasCidades) {
      System.out.printf("Cidade %s - Estado: %s\n", cidade.getNome(), cidade.getEstado().getNome());
    }
  }
  
}
