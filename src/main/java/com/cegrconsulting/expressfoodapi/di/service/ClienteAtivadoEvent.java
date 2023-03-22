package com.cegrconsulting.expressfoodapi.di.service;

import com.cegrconsulting.expressfoodapi.di.modelo.Cliente;

public class ClienteAtivadoEvent {

  private Cliente cliente;

  public ClienteAtivadoEvent(Cliente cliente) {
    this.cliente = cliente;
  }

  public Cliente getCliente() {
    return this.cliente;
  }
  
}
