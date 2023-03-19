package com.cegrconsulting.expressfoodapi.di.notificacao;

import com.cegrconsulting.expressfoodapi.di.modelo.Cliente;

public interface Notificador {

  void notificar(Cliente cliente, String mensagem);

}