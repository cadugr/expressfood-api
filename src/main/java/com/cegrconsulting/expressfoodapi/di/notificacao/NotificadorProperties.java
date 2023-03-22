package com.cegrconsulting.expressfoodapi.di.notificacao;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component //A classe necessita ser um componente Spring
@ConfigurationProperties("notificador.email")
public class NotificadorProperties {

  /**
   * Host do servidor de e-mail
   */
  private String hostServidor;

  /**
   * Porta do servidor de e-mail
   */
  private Integer portaServidor = 25;

  public String getHostServidor() {
    return this.hostServidor;
  }

  public void setHostServidor(String hostServidor) {
    this.hostServidor = hostServidor;
  }

  public Integer getPortaServidor() {
    return this.portaServidor;
  }

  public void setPortaServidor(Integer portaServidor) {
    this.portaServidor = portaServidor;
  }

}
