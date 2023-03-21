package com.cegrconsulting.expressfoodapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cegrconsulting.expressfoodapi.di.notificacao.NotificadorEmail;

@Configuration
public class NotificacaoConfig {

  @Bean
  public NotificadorEmail notificadorEmail() {
    NotificadorEmail notificador = new NotificadorEmail("smtp.expressmail.com.br");
    notificador.setCaixaAlta(false);

    return notificador;
  }
  
}
