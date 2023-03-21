package com.cegrconsulting.expressfoodapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cegrconsulting.expressfoodapi.di.notificacao.NotificadorEmail;
import com.cegrconsulting.expressfoodapi.di.service.AtivacaoClienteService;

//@Configuration
public class AlgaConfig {

  @Bean
  public NotificadorEmail notificadorEmail() {
    NotificadorEmail notificador = new NotificadorEmail("smtp.expressmail.com.br");
    notificador.setCaixaAlta(false);

    return notificador;
  }

  @Bean
  public AtivacaoClienteService ativacaoClienteService() {
    return new AtivacaoClienteService(notificadorEmail());
  }
  
}
