package com.cegrconsulting.expressfoodapi.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cegrconsulting.expressfoodapi.di.service.ClienteAtivadoEvent;

@Component
public class EmissaoNotaFiscalService {

  @EventListener //Com esta anotação, estamos dizendo que este método é um ouvinte de um evento.
  public void clienteAtivadoListener(ClienteAtivadoEvent event) {
    System.out.println("Emitindo nota fiscal para o cliente " + event.getCliente().getNome());
  }
  
}
