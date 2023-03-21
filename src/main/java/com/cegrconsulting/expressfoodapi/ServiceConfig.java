package com.cegrconsulting.expressfoodapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cegrconsulting.expressfoodapi.di.notificacao.Notificador;
import com.cegrconsulting.expressfoodapi.di.service.AtivacaoClienteService;

@Configuration
public class ServiceConfig {

  @Bean
  public AtivacaoClienteService ativacaoClienteService(Notificador notificador) {
    return new AtivacaoClienteService(notificador);
  }
  
}
