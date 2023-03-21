package com.cegrconsulting.expressfoodapi.di.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cegrconsulting.expressfoodapi.di.modelo.Cliente;
import com.cegrconsulting.expressfoodapi.di.notificacao.Notificador;

@Component
public class AtivacaoClienteService {

	@Autowired
	private List<Notificador> notificadores;

	// @Autowired
	// public AtivacaoClienteService(Notificador notificador) {
	// 	this.notificador = notificador;
	// }
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		for(Notificador notificador : notificadores) {
			notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
		}
		
	}

	// @Autowired
	// public void setNotificador(Notificador notificador) {
	// 	this.notificador = notificador;
	// }

}
