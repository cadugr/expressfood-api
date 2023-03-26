package com.cegrconsulting.expressfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.cegrconsulting.expressfood.ExpressfoodApiApplication;
import com.cegrconsulting.expressfood.domain.model.Estado;
import com.cegrconsulting.expressfood.domain.repository.EstadoRepository;

public class ConsultaEstadoMain {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new SpringApplicationBuilder(ExpressfoodApiApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);

    EstadoRepository estados = applicationContext.getBean(EstadoRepository.class);
    
    List<Estado> todosEstados = estados.listar();

    for(Estado estado: todosEstados) {
      System.out.printf("Estado: %s\n", estado.getNome());
    }
  }
  
}
