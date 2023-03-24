package com.cegrconsulting.expressfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.cegrconsulting.expressfood.ExpressfoodApiApplication;
import com.cegrconsulting.expressfood.domain.model.Permissao;
import com.cegrconsulting.expressfood.domain.repository.PermissaoRepository;

public class ConsultaPermissaoMain {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new SpringApplicationBuilder(ExpressfoodApiApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);

    PermissaoRepository permissoes = applicationContext.getBean(PermissaoRepository.class);
    
    List<Permissao> todasPermissoes = permissoes.todas();

    for(Permissao permissao: todasPermissoes) {
      System.out.printf("Permissão: %s - %s\n", permissao.getNome(), permissao.getDescricao());
    }
  }
  
}
