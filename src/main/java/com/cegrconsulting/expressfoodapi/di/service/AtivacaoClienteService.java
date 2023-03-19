package com.cegrconsulting.expressfoodapi.di.service;

import org.springframework.stereotype.Component;

import com.cegrconsulting.expressfoodapi.di.modelo.Cliente;
import com.cegrconsulting.expressfoodapi.di.notificacao.NotificadorEmail;

@Component
public class AtivacaoClienteService {

	private NotificadorEmail notificador;
	
	public void ativar(Cliente cliente) {
		cliente.ativar();

		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}
	
}
