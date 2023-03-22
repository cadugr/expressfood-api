package com.cegrconsulting.expressfoodapi.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cegrconsulting.expressfoodapi.di.notificacao.NivelUrgencia;
import com.cegrconsulting.expressfoodapi.di.notificacao.Notificador;
import com.cegrconsulting.expressfoodapi.di.notificacao.TipoDoNotificador;
import com.cegrconsulting.expressfoodapi.di.service.ClienteAtivadoEvent;

@Component //atentar para o fato que a classe necessita ser um componente Spring.
public class NotificacaoService {

  @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
  @Autowired
  private Notificador notificador;
  
  @EventListener //Com esta anotação, estamos dizendo que este método é um ouvinte de um evento.
  public void clienteAtivadoListener(ClienteAtivadoEvent event) {
    notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo!");
  }

  //inclusive poderíamos ter outros event listeners nesta classe.

}
