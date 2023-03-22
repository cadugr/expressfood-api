package com.cegrconsulting.expressfoodapi.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.cegrconsulting.expressfoodapi.di.modelo.Cliente;

@Component
public class AtivacaoClienteService { 

	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
	}

}
