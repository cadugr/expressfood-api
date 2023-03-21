package com.cegrconsulting.expressfoodapi.di.service;

import com.cegrconsulting.expressfoodapi.di.modelo.Cliente;
import com.cegrconsulting.expressfoodapi.di.notificacao.Notificador;


public class AtivacaoClienteService {

	private Notificador notificador;


	public AtivacaoClienteService(Notificador notificador) {
		this.notificador = notificador;
	  System.out.println("AtivacaoClienteService: " + notificador); 
	}

	
	public void ativar(Cliente cliente) {
		cliente.ativar();

		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}
	
}
