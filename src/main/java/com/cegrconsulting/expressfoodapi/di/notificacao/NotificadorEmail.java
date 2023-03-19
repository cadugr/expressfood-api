package com.cegrconsulting.expressfoodapi.di.notificacao;

import org.springframework.stereotype.Component;

import com.cegrconsulting.expressfoodapi.di.modelo.Cliente;

@Component
public class NotificadorEmail {
	
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s através do e-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}
	
}
